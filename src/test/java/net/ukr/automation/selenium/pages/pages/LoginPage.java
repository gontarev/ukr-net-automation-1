package net.ukr.automation.selenium.pages.pages;

import net.ukr.automation.selenium.pages.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends Page {

    @FindBy(id = "id-l")
    private WebElement login;

    @FindBy(id = "id-p")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    @FindBy(css = "button.default.compose")
    private WebElement composeBtn;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void open()
    {
        driver.get(baseUrl);
    }

    public void login(User user)
    {
        open();
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        submit.click();
        wait.until(elementToBeClickable(composeBtn));
    }
}
