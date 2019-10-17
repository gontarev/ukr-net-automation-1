package net.ukr.automation.selenium.pages;

import net.ukr.automation.selenium.pages.app.MailApplication;
import org.junit.Before;

public class BaseTest {
    public static ThreadLocal<MailApplication> tlApp = new ThreadLocal<>();
    public MailApplication app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new MailApplication();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
