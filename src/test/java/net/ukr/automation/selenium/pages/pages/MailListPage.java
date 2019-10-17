package net.ukr.automation.selenium.pages.pages;

import net.ukr.automation.selenium.pages.data.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MailListPage extends Page {

    public MailListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMailPresentInFolder (Mail mail)
    {
      return  wait.until(elementToBeClickable(By.cssSelector("td.msglist__row-subject"))).getText().trim().equals(mail.getSubjAndBodyLine());
    }
}
