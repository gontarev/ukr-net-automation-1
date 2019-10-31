package net.ukr.automation.selenium.session11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void searchAndOpenSelenideSite() {
        open("http://google.com");
        $(By.name("q")).sendKeys("selenide" + Keys.ENTER);
        $("h3").click();
        $("div.news div.news-line").shouldHave(text("Selenide 5.4.0 5.4.1: Статики победили"));
    }

    @Test
    public void secondTest()
    {
        open("https://mail.ukr.net");
        $("[id=id-l]").sendKeys("login");
        $(By.id("id-p")).sendKeys("password");
        $("button[type='submit']").click();
        $("button.default.compose").shouldHave(text("Написати листа"));


    }
}
