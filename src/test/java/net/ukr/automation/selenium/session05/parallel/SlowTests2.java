package net.ukr.automation.selenium.session05.parallel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SlowTests2 extends TestBase {

//    WebDriver driver;
//
//    @Before
//    public void setup()
//    {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
//    @After
//    public void  cleanup()
//    {
//        driver.quit();
//    }

    @Test
    public void one() {
        driver.navigate().to("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("webdriver");
    }

    @Test
    public void two() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

    @Test
    public void three() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

    @Test
    public void four() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

    @Test
    public void five() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

    @Test
    public void six() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

}