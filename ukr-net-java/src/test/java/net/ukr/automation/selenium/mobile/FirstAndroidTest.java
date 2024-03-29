package net.ukr.automation.selenium.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    private static WebDriverWait wait;
    private static AndroidDriver<WebElement> driver;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");


        URL serverURL = new URL("http://172.22.68.28:4723/wd/hub");

        driver = new AndroidDriver<>(serverURL, dc);
        wait = new WebDriverWait(driver, 4);
    }

    @AfterClass
    public static void stop() {
        driver.closeApp();
    }

    @Test
    public void androidTest() {

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();

        Assert.assertEquals(driver.findElement(By.id("com.android.calculator2:id/formula")).getText(), "11+23");
        Assert.assertEquals(driver.findElement(By.id("com.android.calculator2:id/result")).getText(), "34");

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        Assert.assertEquals(driver.findElement(By.id("com.android.calculator2:id/result")).getText(), "34");

        driver.findElement(By.id("com.android.calculator2:id/toolbar")).click();
        driver.findElementByClassName("android.widget.ImageButton").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/title"))).click();
        driver.findElement(By.id("com.android.calculator2:id/mode")).click();

        Assert.assertEquals(driver.findElement(By.id("com.android.calculator2:id/result")).getText(), "34");
    }
}
