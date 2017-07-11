package com.ahold.ecommerce.definitions.ah.checkout;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.ahold.ecommerce.data._JsonData;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Checkout selected product(s) on AH web and finish order")
    public void orderProduct() {

        //TODO - replace xpath with Selenide filter option!

        // getting through checkout flow
        $(testDataHook(testdata.JsonData("webelements_checkout", "Online bestellen"))).click();
        $(byXpath(testdata.JsonData("webelements_checkout", "AH Pick Up Point"))).shouldBe(visible).click();
        $(testDataHook(testdata.JsonData("webelements_checkout", "Timeslot 6"))).click();
        $(testDataHook(testdata.JsonData("webelements_checkout", "Afronden"))).click();
        $(byXpath(testdata.JsonData("webelements_checkout", "Volgende"))).shouldBe(visible).click();

        // confirm order
        //$(byXpath(testdata.JsonData("webelements_checkout", "Bevestig bestelling"))).shouldBe(visible).click();
    }
}
