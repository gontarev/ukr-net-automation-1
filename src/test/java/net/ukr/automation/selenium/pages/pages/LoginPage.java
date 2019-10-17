package net.ukr.automation.selenium.pages.pages;


import net.ukr.automation.selenium.pages.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void open()
    {
        driver.get(baseUrl);
    }

    public void login(User user)
    {
        open();
        driver.findElement(By.id("id-l")).sendKeys(user.getLogin());
        driver.findElement(By.id("id-p")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(elementToBeClickable(By.cssSelector("button.default.compose")));
    }
}
