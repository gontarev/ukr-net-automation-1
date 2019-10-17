package net.ukr.automation.selenium.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SideBarPage extends Page {

    public SideBarPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnWriteNewLetter()
    {
        wait.until(elementToBeClickable(By.cssSelector("button.default.compose"))).click();
    }

    public void openInbox()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\30 > .sidebar__list-link-name"))).click();
    }

    public void openDeleted()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0004 > .sidebar__list-link-name"))).click();
    }

    public void openSentItems()
    {
        wait.until(elementToBeClickable(By.cssSelector("#\\31 0001 > .sidebar__list-link-name"))).click();
    }

}
