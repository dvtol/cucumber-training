package com.politienl.regressie.definitions.politie.nl.zoeken;

import com.politienl.regressie.data._JsonData;
import com.politienl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class ZoekenPage extends BasePage {

    public ZoekenPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Zoek functionaliteit op specifieke termen")
    protected void enterInSearchBox() {

        Configuration.timeout = 15000;
        $(By.id("searchinput")).setValue(testdata.JsonData("webelements_search", "Search keywords")).submit();
    }
}