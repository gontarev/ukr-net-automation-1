package net.ukr.automation.selenium.session09;

import net.ukr.automation.selenium.session05.parallel.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class BrowserLogs {

    WebDriver drv;

    @Before
    public void newDrv()
    {
        ChromeOptions opt = new ChromeOptions();

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        opt.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        opt.setExperimentalOption("w3c",false);
        drv = new ChromeDriver(opt);
    }


    @Test
    public void simpleLogs() {

        System.out.println(drv.manage().logs().getAvailableLogTypes());

        drv.get("https://www.facebook.com/");

        String[] logTypes = {"browser", "driver", "client"};

        for (String logType : logTypes) {
            for (LogEntry l : drv.manage().logs().get(logType).getAll()) {
                System.out.println(logType + ":" + l);
            }
        }

    }

    @Test
    public void performanceLogs() {

        System.out.println(drv.manage().logs().getAvailableLogTypes());
        drv.get("https://anotepad.com/");

        for (LogEntry entry : drv.manage().logs().get(LogType.PERFORMANCE)) {
            System.out.println(entry.toString());
        }
    }

    @After
    public void stopLocalDriver() {
        if (drv != null) {
            drv.quit();
            drv = null;
        }
    }
}
