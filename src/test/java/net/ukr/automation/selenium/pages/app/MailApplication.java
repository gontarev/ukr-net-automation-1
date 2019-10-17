package net.ukr.automation.selenium.pages.app;

import net.ukr.automation.selenium.pages.data.User;
import net.ukr.automation.selenium.pages.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailApplication {

    private WebDriver driver;
    private LoginPage loginPage;

    public MailApplication() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void login(User user)
    {
        loginPage.login(user);
    }

}
