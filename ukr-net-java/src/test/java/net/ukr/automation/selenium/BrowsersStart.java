package net.ukr.automation.selenium;

import net.ukr.automation.selenium.utils.Browser;
import net.ukr.automation.selenium.utils.Driver;
import org.openqa.selenium.WebDriver;

public class BrowsersStart {

    public static void main(String[] args) {
        String baseURL = "https://www.ukr.net/ua/";

        for (Browser browser : Browser.values()) {
            try {
                System.out.println(browser.toString());
                WebDriver driver = Driver.getDriver(browser, "start-fullscreen");
                driver.get(baseURL);
                driver.quit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}