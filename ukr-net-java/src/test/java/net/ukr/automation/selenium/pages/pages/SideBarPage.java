package net.ukr.automation.selenium.pages.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SideBarPage extends Page {

    public SideBarPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickOnWriteNewLetter()
    {
        wait.until(elementToBeClickable(By.cssSelector("button.default.compose"))).click();
    }

    @Step
    public void openInbox()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\30 > .sidebar__list-link-name"))).click();
    }
    @Step

    public void openDeleted()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0004 > .sidebar__list-link-name"))).click();
    }
    @Step
    public void openSentItems()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0001 > .sidebar__list-link-name"))).click();
    }

}
