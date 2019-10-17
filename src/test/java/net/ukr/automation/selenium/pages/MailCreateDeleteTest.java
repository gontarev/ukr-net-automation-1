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
        user = new User("xxxx", "yyyyyy");
        mail = new Mail(user).setSubject("Demo Letter").setBody("Hi There");
    }


    @Test
    public void createDeleteTest() {
        app.login(user);
        app.sendNewMail(mail);
        app.openInbox();

        Assert.assertTrue(app.getMailList().isMailPresentInFolder(mail));

        app.openMessage(mail);

        Assert.assertTrue(app.getMailList().isBodyEqualTo(mail.getBody()));

        app.deleteCurrentMail();
        app.openDeleted();

        Assert.assertTrue(app.getMailList().isMailPresentInFolder(mail));

        app.cleanUpDeletedFolder();

        Assert.assertTrue(app.getMailList().isDeletedFolderEmpty());


    }

    @Test
    public void newTest()
    {
        app.login(user);
        app.sendNewMail(mail);
        app.openSentItems();
        app.cleanUpFolder();

        Assert.assertTrue(app.getMailList().isFolderEmpty());

    }

}