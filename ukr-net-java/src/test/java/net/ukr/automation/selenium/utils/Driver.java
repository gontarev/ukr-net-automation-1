package net.ukr.automation.selenium.utils;

import net.ukr.automation.selenium.utils.exceptions.NoSuchBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.List;

public class Driver {

    public static WebDriver getDriver(Browser browser, String argument) throws NoSuchBrowserException {

        switch (browser)
        {
            case CHROME:
                return new ChromeDriver(new ChromeOptions().addArguments(argument));
            case FIREFOX:
                return new FirefoxDriver(new FirefoxOptions().addArguments(argument));
            case IE:
                return new InternetExplorerDriver(new InternetExplorerOptions().addCommandSwitches(argument));
            default:
                throw new NoSuchBrowserException(browser.toString() + " is not supported yet");
        }
    }

}
