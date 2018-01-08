package com.kvknl.regressie.definitions.kvkor.newregistration.overview;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.definitions.generic.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage extends BasePage {

    public OverviewPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("het valideren, ondertekenen en indienen van de opgave")
    public void validateSignAndSumbit() {

        $(By.id("valideren")).click();
        $(By.id("Opslaan")).click();
    }
}


