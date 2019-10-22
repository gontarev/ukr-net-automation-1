package net.ukr.automation.selenium.pages.app;

import io.qameta.allure.Step;
import net.ukr.automation.selenium.pages.data.Mail;
import net.ukr.automation.selenium.pages.data.User;
import net.ukr.automation.selenium.pages.pages.LoginPage;
import net.ukr.automation.selenium.pages.pages.MailComposePage;
import net.ukr.automation.selenium.pages.pages.MailListPage;
import net.ukr.automation.selenium.pages.pages.SideBarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailApplication {

    private WebDriver driver;
    private LoginPage loginPage;
    private MailComposePage composePage;
    private SideBarPage sideBar;
    private MailListPage mailList;

    public MailApplication() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        composePage = new MailComposePage(driver);
        sideBar = new SideBarPage(driver);
        mailList = new MailListPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    @Step
    public void login(User user)
    {
        loginPage.open();
        loginPage.login(user);
    }

    @Step
    public void sendNewMail(Mail mail)
    {
        sideBar.clickOnWriteNewLetter();
        composePage.composeAndSendNewMail(mail);
    }

    public SideBarPage getSideBar()
    {
        return sideBar;
    }

    public MailListPage getMailList() {
        return mailList;
    }
    @Step
    public void openMessage(Mail mail) {
        mailList.openMail(mail);
    }

    @Step public void deleteCurrentMail() {
        mailList.deleteCurrentMail();
    }

    @Step public void cleanUpDeletedFolder() {
        mailList.cleanUpDeletedFolder();
    }

    @Step public void cleanUpFolder() {
        mailList.cleanUpFolder();
    }

    @Step public void openInbox() {
        sideBar.openInbox();
    }

    @Step public void openDeleted() {
        sideBar.openDeleted();
    }

    @Step public void openSentItems() {
        sideBar.openSentItems();
    }
}
