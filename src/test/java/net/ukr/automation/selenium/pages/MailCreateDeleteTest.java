package net.ukr.automation.selenium.pages;

import net.ukr.automation.selenium.pages.data.Mail;
import net.ukr.automation.selenium.pages.data.User;
import org.junit.Test;
import org.junit.Before;


public class MailCreateDeleteTest extends BaseTest {
    private User user;
    private Mail mail;

    @Before
    public void setUp() {
        user = new User("selenium3", "FAm58ArwG4$9UU$3");
        mail = new Mail(user).setSubject("Demo Letter").setBody("Hi There");
    }


    @Test
    public void createDeleteTest() {
        app.login(user);
        app.sendNewMail(mail);
//        checkMailIsReceived();
//        deleteMail();
//        cleanUpDeleted();
    }


//    private void sendNewMail() {
//        wait.until(elementToBeClickable(By.cssSelector("button.default.compose"))).click();
//        wait.until(elementToBeClickable(By.name("toFieldInput"))).sendKeys(mail.getUser().getMail());
//        driver.findElement(By.name("subject")).sendKeys(mail.getSubject());
//        driver.switchTo().frame(1);
//        driver.findElement(By.id("tinymce")).sendKeys(mail.getBody());
//        driver.switchTo().defaultContent();
//        driver.findElement(By.cssSelector(".send")).click();
//        assertThat(wait.until(elementToBeClickable(By.cssSelector(".sendmsg__ads-ready"))).getText(), is("Ваш лист надіслано\nНаписати щеПовернутись у вхідні"));
//
//    }
//
//    private void checkMailIsReceived() {
//        driver.findElement(By.cssSelector("#\\30 > .sidebar__list-link-name")).click();
//        assertThat(wait.until(elementToBeClickable(By.cssSelector("td.msglist__row-subject"))).getText().trim(), is(mail.getSubjAndBodyLine()));
//        driver.findElement(By.cssSelector(".msglist__row-address-wrap")).click();
//        assertThat(wait.until(elementToBeClickable(By.cssSelector(".xfmc1"))).getText(), is(mail.getBody()));
//    }
//
//    private void deleteMail() {
//        driver.findElement(By.linkText("Видалити")).click();
//    }
//
//    private void cleanUpDeleted() {
//        wait.until(elementToBeClickable(By.cssSelector("#\\31 0004 > .sidebar__list-link-name"))).click();
//        wait.until(elementToBeClickable(By.cssSelector(".msglist__checkbox .checkbox span"))).click();
//        wait.until(elementToBeClickable(By.linkText("Видалити назавжди"))).click();
//        assertThat(wait.until(elementToBeClickable(By.cssSelector(".msglist__empty > td"))).getText(), is("В цій папці немає листів\nВи можете створити фільтр для автоматичного переміщення листів у цю папку"));
//    }

}