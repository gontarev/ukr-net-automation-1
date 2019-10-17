package net.ukr.automation.selenium.pages;

import net.ukr.automation.selenium.pages.data.Mail;
import net.ukr.automation.selenium.pages.data.User;
import org.junit.Assert;
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
        app.getSideBar().openInbox();
        Assert.assertTrue(app.getMailList().isMailPresentInFolder(mail));

//        checkMailIsReceived();
//        deleteMail();
//        cleanUpDeleted();
    }


//
//    private void checkMailIsReceived() {
//
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
//
//        wait.until(elementToBeClickable(By.cssSelector(".msglist__checkbox .checkbox span"))).click();
//        wait.until(elementToBeClickable(By.linkText("Видалити назавжди"))).click();
//        assertThat(wait.until(elementToBeClickable(By.cssSelector(".msglist__empty > td"))).getText(), is("В цій папці немає листів\nВи можете створити фільтр для автоматичного переміщення листів у цю папку"));
//    }

}