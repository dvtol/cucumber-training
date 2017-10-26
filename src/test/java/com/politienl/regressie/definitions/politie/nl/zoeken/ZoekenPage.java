package com.politienl.regressie.definitions.politie.nl.ordering;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.politienl.regressie.data._JsonData;
import com.politienl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Ordering product(s) on AH web")
    public void productSelection() {

        Configuration.timeout = 15000;

        // product selection flow
        $(testDataHook(testdata.JsonData("webelements_order", "Producten Home"))).click();
        $(testDataHook(testdata.JsonData("webelements_order", "Bakkerij"))).shouldBe(Condition.visible).click();
        $(testDataHook(testdata.JsonData("webelements_order", "AG Goois zonnepittenbrood wit"))).shouldBe(Condition.visible).click();
        $(testDataHook(testdata.JsonData("webelements_order", "AH Ciabatta brood"))).shouldBe(Condition.visible).click();
        $(testDataHook(testdata.JsonData("webelements_order", "Mijn lijst Home"))).shouldHave(text("2")).click();
    }
}