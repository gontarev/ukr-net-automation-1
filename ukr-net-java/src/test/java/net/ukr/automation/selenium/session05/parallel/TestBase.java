package net.ukr.automation.selenium.session05.parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() throws MalformedURLException {

        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver,10);
            return;
        }

        ChromeOptions opt = new ChromeOptions();
        //opt.setExperimentalOption("w3c",false);

        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver,10);

        tlDriver.set(driver);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                }));
    }

    public String getTestURL() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.html").getFile());
        return "file:///"+
                file.getAbsolutePath().toString();
    }

}
