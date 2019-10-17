package net.ukr.automation.selenium.pages;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailCreateDeleteTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createDeleteTest() {
        driver.get("https://accounts.ukr.net/login");
        driver.findElement(By.id("id-l")).sendKeys("selenium3");
        driver.findElement(By.id("id-p")).sendKeys("FAm58ArwG4$9UU$3");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(elementToBeClickable(By.cssSelector("button.default.compose"))).click();
        wait.until(elementToBeClickable(By.name("toFieldInput"))).sendKeys(" selenium3@ukr.net");
        driver.findElement(By.name("subject")).sendKeys("Demo Letter");
        driver.switchTo().frame(1);
        driver.findElement(By.id("tinymce")).sendKeys("Hi There");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".send")).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".sendmsg__ads-ready"))).getText(), is("Ваш лист надіслано\nНаписати щеПовернутись у вхідні"));
        driver.findElement(By.cssSelector("#\\30 > .sidebar__list-link-name")).click();
        assertThat(wait.until(elementToBeClickable(By.linkText("Demo Letter  Hi There"))).getText(), is("Demo Letter  Hi There "));
        driver.findElement(By.cssSelector(".msglist__row-address-wrap")).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".xfmc1"))).getText(), is("Hi There"));
        driver.findElement(By.linkText("Видалити")).click();
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0004 > .sidebar__list-link-name"))).click();
        wait.until(elementToBeClickable(By.cssSelector(".msglist__checkbox .checkbox span"))).click();
        wait.until(elementToBeClickable(By.linkText("Видалити назавжди"))).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".msglist__empty > td"))).getText(), is("В цій папці немає листів\nВи можете створити фільтр для автоматичного переміщення листів у цю папку"));
    }
}