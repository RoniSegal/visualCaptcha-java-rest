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
    PhantomJSDriver driver;
    @Before
    public void setup() throws InterruptedException {
        ArrayList<String> cliArgsCap = new ArrayList<String>();
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        cliArgsCap.add("--web-security=false");
        cliArgsCap.add("--ssl-protocol=any");
        cliArgsCap.add("--ignore-ssl-errors=true");
        cliArgsCap.add("--local-to-remote-url-access=true");
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        String phantomExe = "phantomjs.exe";
        if (OSValidator.isUnix())
            phantomExe = "phantomjs";
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomExe);
        driver = new PhantomJSDriver(capabilities);
        driver.get("http://localhost:8124/");
        driver.wait(20*1000);
    }
    @Test
    public void testSayHello() throws InterruptedException {
        Thread.sleep(10*1000);
        driver.findElement(By.cssSelector("#say-hello")).click();

        Thread.sleep(15*1000);
        String text = driver.findElement(By.cssSelector("#output")).getText();
        Assert.assertEquals("Hello World", text);
    }
    @Test
    public void testDoMagic() throws InterruptedException {
        Thread.sleep(10*1000);
        driver.findElement(By.cssSelector("#do-magic")).click();
        Thread.sleep(15*1000);
        String text = driver.findElement(By.cssSelector("#output")).getText();
        Assert.assertEquals("Do Magic", text);
    }



}
