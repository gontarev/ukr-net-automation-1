package net.ukr.automation.selenium.session09;

import net.ukr.automation.selenium.session09.listeners.Listener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class EventsListenerTest {

    EventFiringWebDriver edr;
    WebDriverWait wait;

    @Before
    public void start() {
        edr = new EventFiringWebDriver(new ChromeDriver());
        edr.register(new Listener());
        wait = new WebDriverWait(edr, 5);
    }

    @After
    public void stop() {
        edr.quit();
    }

    @Test
    public void listenerTest() {
        edr.get("http://demo.litecart.net/admin/");
        edr.findElement(By.cssSelector(".btn-default")).click();

        WebDriverWait wait = new WebDriverWait(edr, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".name")));

        List<WebElement> menuItems = getMenuItems();
        List<WebElement> subMenuItems = getSubMenuItems();

        int menuItemsCount = menuItems.size();
        int subMenuItemsCount = subMenuItems.size();

        for (int i = 0; i < menuItemsCount; i++) {
            menuItems.get(i).click();
            // Assert.assertTrue(isTagPresent());
            subMenuItems = getSubMenuItems();
            subMenuItemsCount = subMenuItems.size();

            if (subMenuItemsCount > 0) {
                for (int j = 0; j < subMenuItemsCount; j++) {
                    subMenuItems.get(j).click();
                    // Assert.assertTrue(isTagPresent());
                    subMenuItems = getSubMenuItems();
                }
            }
            menuItems = getMenuItems();
        }
    }

    private boolean isTagPresent() {
        return edr.findElements((By.tagName("h1"))).size() > 0;
    }

    private List<WebElement> getMenuItems() {
        return edr.findElements(By.cssSelector("li.app"));
    }

    private List<WebElement> getSubMenuItems() {
        return edr.findElements(By.cssSelector("li[class*='doc-']"));
    }

}
