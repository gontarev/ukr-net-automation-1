package net.ukr.automation.selenium.utils;

import net.ukr.automation.oop.base.WebDriver;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverProvider {

    public  RemoteWebDriver getDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        return new RemoteWebDriver(
                URI.create("http://192.168.56.101:4444/wd/hub").toURL(),
                capabilities
        );

    }
}
