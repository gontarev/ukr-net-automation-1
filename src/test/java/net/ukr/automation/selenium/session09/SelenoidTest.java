package net.ukr.automation.selenium.session09;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

public class SelenoidTest {

    static RemoteWebDriver drv;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("72.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        drv = new RemoteWebDriver(
                URI.create("http://192.168.56.102:4444/wd/hub").toURL(),
                capabilities
        );

        drv.manage().window().setSize(new Dimension(1800, 800));

    }

    @AfterClass
    public static void stop() {
        drv.quit();
    }

    @Test
    public void remoteTest() {
        drv.get("http://google.com");
        drv.findElementByName("q").sendKeys("Remote WebDriver" + Keys.ENTER);
    }

    @Test
    public void litecartTest() {
        drv.get("http://demo.litecart.net/admin/");
        drv.findElement(By.cssSelector(".btn-default")).click();

        WebDriverWait wait = new WebDriverWait(drv, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".name")));

        List<WebElement> menuItems = getMenuItems();
        List<WebElement> subMenuItems = getSubMenuItems();

        int menuItemsCount = menuItems.size();
        int subMenuItemsCount = subMenuItems.size();

        for (int i = 0; i < menuItemsCount; i++) {
            menuItems.get(i).click();
            Assert.assertTrue(isTagPresent());
            subMenuItems = getSubMenuItems();
            subMenuItemsCount = subMenuItems.size();

            if (subMenuItemsCount > 0) {
                for (int j = 0; j < subMenuItemsCount; j++) {
                    subMenuItems.get(j).click();
                    Assert.assertTrue(isTagPresent());
                    subMenuItems = getSubMenuItems();
                }
            }
            menuItems = getMenuItems();
        }
    }

    private boolean isTagPresent() {
        return drv.findElements((By.tagName("h1"))).size() > 0;
    }

    private List<WebElement> getMenuItems() {
        return drv.findElements(By.cssSelector("li[id*='app-']"));
    }

    private List<WebElement> getSubMenuItems() {
        return drv.findElements(By.cssSelector("li[id*='doc-']"));
    }


}
