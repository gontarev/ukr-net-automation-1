package net.ukr.automation.selenium.pages.pages;

import net.ukr.automation.selenium.pages.data.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MailListPage extends Page {

    @FindBy(css = ".msglist__checkbox .checkbox span")
    WebElement selectAllChkBox;

    By listArea = By.cssSelector(".msglist__empty > td");

    public MailListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isMailPresentInFolder (Mail mail)
    {
      return  wait.until(elementToBeClickable(By.cssSelector("td.msglist__row-subject"))).getText().trim().equals(mail.getSubjAndBodyLine());
    }

    public void openMail(Mail mail)
    {
        driver.findElement(By.cssSelector(".msglist__row-address-wrap")).click();
    }

    public boolean isBodyEqualTo(String body)
    {
        return wait.until(elementToBeClickable(By.cssSelector(".xfmc1"))).getText().equals(body);
    }

    public void deleteCurrentMail()
    {
        driver.findElement(By.linkText("Видалити")).click();
    }

    public void cleanUpDeletedFolder()
    {
        wait.until(elementToBeClickable(selectAllChkBox)).click();
        wait.until(elementToBeClickable(By.linkText("Видалити назавжди"))).click();
    }

    public boolean isDeletedFolderEmpty()
    {
        return wait.until(elementToBeClickable(listArea)).getText().equals("В цій папці немає листів\nВи можете створити фільтр для автоматичного переміщення листів у цю папку");
    }

    public void cleanUpFolder() {
        wait.until(elementToBeClickable(selectAllChkBox)).click();
        wait.until(elementToBeClickable(By.linkText("Видалити"))).click();
    }

    public boolean isFolderEmpty() {
        return wait.until(elementToBeClickable(listArea)).getText().equals("В цій папці немає листів");
    }
}
