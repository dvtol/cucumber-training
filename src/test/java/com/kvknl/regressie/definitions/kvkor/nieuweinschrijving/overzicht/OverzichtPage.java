package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.overzicht;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class OverzichtPage extends BasePage {

    public OverzichtPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het valideren, ondertekenen en indienen van de opgave")
    public void ValiderenOndertekenenIndienen() {

        $(By.id("valideren")).click();
        $(By.id("Opslaan")).click();
    }
}


