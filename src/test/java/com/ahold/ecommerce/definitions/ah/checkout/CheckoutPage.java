package com.ahold.ecommerce.definitions.ah.checkout;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.ahold.ecommerce.data._JsonData;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Checkout selected product(s) on AH web and finish order")
    public void orderProduct() {

        Configuration.timeout = 8000;

        // getting through checkout flow
        $(testDataHook(testdata.JsonData("webelements_checkout", "Online bestellen"))).click();
        $$(By.xpath(testdata.JsonData("webelements_checkout", "AH Pick Up Point"))).filterBy(visible).get(0).click();
        $(testDataHook(testdata.JsonData("webelements_checkout", "Timeslot 6"))).click();
        $(testDataHook(testdata.JsonData("webelements_checkout", "Afronden"))).click();
        $$(By.xpath(testdata.JsonData("webelements_checkout", "Volgende"))).filterBy(visible).get(0).click();;

        // confirm order
        $$(By.xpath(testdata.JsonData("webelements_checkout", "Bevestig bestelling"))).filterBy(visible).get(0).click();
    }
}
