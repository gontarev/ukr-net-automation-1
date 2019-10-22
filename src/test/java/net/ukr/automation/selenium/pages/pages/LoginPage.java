package net.ukr.automation.selenium.pages.pages;

import io.qameta.allure.Step;
import net.ukr.automation.selenium.pages.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends Page {

    @FindBy(id = "id-l")
    private WebElement loginFld;

    @FindBy(id = "id-p")
    private WebElement passwordFld;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    @FindBy(css = "button.default.compose")
    private WebElement composeBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void open() {
        driver.get(baseUrl);
    }

    @Step
    public void login(User user) {
        if (driver.getCurrentUrl().contains("/login")) {
            loginFld.sendKeys(user.getLogin());
            passwordFld.sendKeys(user.getPassword());
            submitBtn.click();
            wait.until(elementToBeClickable(composeBtn));
        }
    }
}
