package net.ukr.automation.selenium.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://mail.ukr.net";

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 4);
    }
}
