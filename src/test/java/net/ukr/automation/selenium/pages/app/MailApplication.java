package net.ukr.automation.selenium.pages.app;

import net.ukr.automation.selenium.pages.data.Mail;
import net.ukr.automation.selenium.pages.data.User;
import net.ukr.automation.selenium.pages.pages.LoginPage;
import net.ukr.automation.selenium.pages.pages.MailComposePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailApplication {

    private WebDriver driver;
    private LoginPage loginPage;
    private MailComposePage composePage;

    public MailApplication() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        composePage = new MailComposePage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void login(User user)
    {
        loginPage.login(user);
    }

    public void sendNewMail(Mail mail)
    {
        composePage.composeAndSendNewMail(mail);
    }
}
