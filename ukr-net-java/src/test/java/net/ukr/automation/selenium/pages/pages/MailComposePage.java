package net.ukr.automation.selenium.pages.pages;

import io.qameta.allure.Step;
import net.ukr.automation.selenium.pages.data.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MailComposePage extends Page {

    public MailComposePage(WebDriver driver) {
        super(driver);
    }


    @Step("Compose new mail")
    public void composeAndSendNewMail(Mail mail)
    {
        wait.until(elementToBeClickable(By.name("toFieldInput"))).sendKeys(mail.getUser().getMail());
        driver.findElement(By.name("subject")).sendKeys(mail.getSubject());
        driver.switchTo().frame(1);
        driver.findElement(By.id("tinymce")).sendKeys(mail.getBody());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".send")).click();
        wait.until(textToBePresentInElementLocated(By.cssSelector(".sendmsg__ads-ready"), "Ваш лист надіслано\nНаписати щеПовернутись у вхідні"));
    }
}
