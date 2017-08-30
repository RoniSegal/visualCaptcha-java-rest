package com.kuhniverse.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;


public class SealightsUiTest {
    String baseUrl = "http://localhost:8080/";


    private PhantomJSDriver createDriver() {
        ArrayList<String> cliArgsCap = new ArrayList<String>();
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        cliArgsCap.add("--web-security=false");
        cliArgsCap.add("--ssl-protocol=any");
        cliArgsCap.add("--ignore-ssl-errors=true");
        cliArgsCap.add("--local-to-remote-url-access=true");
        //cliArgsCap.add("--remote-debugger-port=12345");
        //cliArgsCap.add("--remote-debugger-autorun=yes");
        //cliArgsCap.add("--proxy==127.0.0.1:8888");

        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        String phantomExe = "phantomjs.exe";
        if (OSValidator.isUnix())
            phantomExe = "phantomjs";
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomExe);
        PhantomJSDriver driver = new PhantomJSDriver(capabilities);
        return driver;
    }

    @Test
    public void testSayHello() throws InterruptedException {
        PhantomJSDriver driver = createDriver();
        driver.get(baseUrl);
        try {
            Thread.sleep(10 * 1000);
            driver.findElement(By.cssSelector("#say-hello")).click();

            Thread.sleep(15 * 1000);
            String text = driver.findElement(By.cssSelector("#output")).getText();
            Assert.assertEquals("Hello World", text);
        } finally {
            driver.quit();
        }

    }

    @Test
    public void testDoMagic() throws InterruptedException {
        PhantomJSDriver driver = createDriver();
        driver.get(baseUrl);
        try {
            Thread.sleep(10 * 1000);
            driver.findElement(By.cssSelector("#do-magic")).click();
            Thread.sleep(15 * 1000);
            String text = driver.findElement(By.cssSelector("#output")).getText();
            Assert.assertEquals("Do Magic", text);
        } finally {
            driver.quit();
        }
    }

    private String getDebugSscript() {
        String script = "var page = this; var userMessageHelper = {}; userMessageHelper[\"info\"]=console.log; userMessageHelper[\"error\"]=console.error;";
        script += "page.onConsoleMessage = function (msg, lineNum, sourceId) {\n";
        script += "  userMessageHelper.info('[Browser] ' + msg);\n";
        script += "};\n";

        script += "page.onResourceRequested = function (requestData, networkRequest) {\n";
        script += "  userMessageHelper.info(\"[Resource Request (#'\" + requestData.id + \"')] =====================================================================================\")\n";
        script += "  userMessageHelper.info('[Resource Request (#' + requestData.id + ')] url: ' + requestData.url);\n";
        script += "  userMessageHelper.info('[Resource Request (#' + requestData.id + ')] data: ' + JSON.stringify(requestData));\n";
        script += "  userMessageHelper.info(\"[Resource Request (#'\" + requestData.id + \"')] =====================================================================================\")\n";
        script += "};\n";


        script += "page.onResourceError = function (resourceError) {\n";
        script += "userMessageHelper.error(\"[Resource Error] =====================================================================================\")\n";
        script += "userMessageHelper.error('[Resource Error] Unable to load resource (#' + resourceError.id + 'URL:' + resourceError.url + ')');\n";
        script += "userMessageHelper.error('[Resource Error] Error code: ' + resourceError.errorCode + '. Description: ' + resourceError.errorString);\n";
        script += "userMessageHelper.error(\"[Resource Error] =====================================================================================\")\n";
        script += "};\n";

        return script;
    }
}
