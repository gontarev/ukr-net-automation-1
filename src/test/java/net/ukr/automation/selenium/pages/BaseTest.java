package net.ukr.automation.selenium.pages;

import net.ukr.automation.selenium.pages.app.MailApplication;
import net.ukr.automation.selenium.utils.TestRules;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

public class BaseTest {

    static MailApplication app;

    @Rule
    public TestRules testRules = new TestRules(app.getDriver());

    @BeforeClass
    public static void startApp() {
        app = new MailApplication();
    }

    @AfterClass
    public static void stopApp()
    {
        app.quit();
    }
}
