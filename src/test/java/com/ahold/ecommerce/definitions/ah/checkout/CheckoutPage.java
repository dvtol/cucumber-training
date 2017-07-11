package com.ahold.ecommerce.definitions.ah.checkout;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
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

        //TODO - replace xpath with Selenide filter option!

        $(testDataHook("link-guidance-to-channel")).click();
        $(byXpath("//*[@id=\"change\"]/label[2]/span[2]")).shouldBe(visible).click();
        $(testDataHook("timeslot-6-selectable")).click();
        $(testDataHook("link-checkout-flow")).click();
        $(byXpath("//*[@id=\"index_1\"]/article/a[2]")).shouldBe(visible).click();

        // confirm order
        $(byXpath("//*[@id=\"index_1\"]/article/a[2]")).click();
    }
}
