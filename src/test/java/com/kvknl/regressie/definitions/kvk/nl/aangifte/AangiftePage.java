package com.kvknl.regressie.definitions.kvk.nl.aangifte;

import com.kvknl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AangiftePage extends BasePage {

    public AangiftePage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    //private _JsonData testdata = new _JsonData();


    @Step("Angifte melding doen middels digid")
    protected void aangifteProcesDigid() {

        Configuration.timeout = 15000;
        $(By.id("aangifte-melding")).click();
        $(By.xpath("//*[@id=\"linkspagina\"]/dl/dd[2]/a")).click();
        $(By.xpath("//*[@id=\"link-diefstal-zakkenrollerij-of-inbraak\"]/ul/li[1]/a")).click();
        $(By.xpath("//*[@id=\"main-content\"]/article/div/div/ul[1]/li/a")).click();
        $(By.id("antwoord-1-false")).click();
        $(By.id("antwoord-2-false")).click();
        $(By.id("antwoord-3-false")).click();
        $(By.id("antwoord-4-false")).click();
        $(By.xpath("//*[@id=\"ia-dialog-footer-goed\"]/button[2]/span[1]")).click();
        $(".main-content").shouldHave(text("Inloggen bij Politie - Burgerportaal"));
    }
}
