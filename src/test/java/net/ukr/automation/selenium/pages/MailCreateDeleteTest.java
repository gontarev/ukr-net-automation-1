package net.ukr.automation.selenium.pages;

import net.ukr.automation.selenium.pages.data.Mail;
import net.ukr.automation.selenium.pages.data.User;
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
    private User user;
    private Mail mail;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        user = new User("selenium3", "FAm58ArwG4$9UU$3");
        mail = new Mail(user);
        mail.setSubject("Demo Letter").setBody("Hi There");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createDeleteTest() {
        login();
        sendNewMail();
        checkMailIsReceived();
        deleteMail();
        cleanUpDeleted();
    }


    private void login() {
        driver.get("https://accounts.ukr.net/login");
        driver.findElement(By.id("id-l")).sendKeys(user.getLogin());
        driver.findElement(By.id("id-p")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }

    private void sendNewMail() {
        wait.until(elementToBeClickable(By.cssSelector("button.default.compose"))).click();
        wait.until(elementToBeClickable(By.name("toFieldInput"))).sendKeys(mail.getUser().getMail());
        driver.findElement(By.name("subject")).sendKeys(mail.getSubject());
        driver.switchTo().frame(1);
        driver.findElement(By.id("tinymce")).sendKeys(mail.getBody());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".send")).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".sendmsg__ads-ready"))).getText(), is("Ваш лист надіслано\nНаписати щеПовернутись у вхідні"));

    }

    private void checkMailIsReceived() {
        driver.findElement(By.cssSelector("#\\30 > .sidebar__list-link-name")).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector("td.msglist__row-subject"))).getText().trim(), is(mail.getSubjAndBodyLine()));
        driver.findElement(By.cssSelector(".msglist__row-address-wrap")).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".xfmc1"))).getText(), is(mail.getBody()));
    }

    private void deleteMail() {
        driver.findElement(By.linkText("Видалити")).click();
    }

    private void cleanUpDeleted() {
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0004 > .sidebar__list-link-name"))).click();
        wait.until(elementToBeClickable(By.cssSelector(".msglist__checkbox .checkbox span"))).click();
        wait.until(elementToBeClickable(By.linkText("Видалити назавжди"))).click();
        assertThat(wait.until(elementToBeClickable(By.cssSelector(".msglist__empty > td"))).getText(), is("В цій папці немає листів\nВи можете створити фільтр для автоматичного переміщення листів у цю папку"));
    }

}