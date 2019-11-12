package net.ukr.automation.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.qatools.properties.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverProvider {

   static TestProperties config = PropertyLoader.newInstance()
            .populate(TestProperties.class);

    public WebDriver getDriver() throws MalformedURLException {

        if (config.getIsRemoteRun()) {
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

        else
        {
            switch (config.getBrowser()) {
                case CHROME:
                return new ChromeDriver();
                default:
                    return new FirefoxDriver();
            }
        }
    }
}
