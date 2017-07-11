package com.ahold.ecommerce.definitions.ah.checkout;

import static com.codeborne.selenide.Selenide.$;

import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("Checkout selected product(s) on AH web and finish order")
    public void orderProduct() {

        $(testDataHook("link-guidance-to-channel")).click();
    }
}
