package net.ukr.automation.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {

    WebDriver driver;

    @Before
    public void start()
    {

        ChromeOptions opt = new ChromeOptions();
        opt.setCapability("unexpectedAlertBehaviour","accept");
        opt.setHeadless(true);

        driver = new ChromeDriver(opt);
    }

    @After
    public void stop()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        driver.get("https://www.ukr.net/ua/");
        System.out.println(((HasCapabilities) driver).getCapabilities());
    }
}