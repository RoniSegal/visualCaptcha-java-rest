package com.kuhniverse.selenium;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
@Config(
        browser = Browser.CHROME,
        url = "http://localhost:8080/"
)
public class SealightsUiTest extends Locomotive {
    @Before
    public void setup() {
        //this.driver.manage().window().maximize();
    }
    @Test
    public void testSayHello() throws InterruptedException {
        Thread.sleep(10*1000);
         click("#say-hello");
        Thread.sleep(15*1000);
        String text = getText("#output");
        Assert.assertEquals("Hello World", text);
    }
    @Test
    public void testDoMagic() throws InterruptedException {
        Thread.sleep(10*1000);
        click("#do-magic");
        Thread.sleep(15*1000);
        String text = getText("#output");
        Assert.assertEquals("Do Magic", text);
    }

}
