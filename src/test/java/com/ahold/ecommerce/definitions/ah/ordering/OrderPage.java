package com.ahold.ecommerce.definitions.ah.ordering;

import static com.codeborne.selenide.Selenide.$;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("Ordering product(s) on AH web")
    public void productSelection() {

        $(testDataHook("navigation-products")).click();
        $(testDataHook("link-2861")).shouldBe(Condition.visible).click();
        $(testDataHook("add_product_wi56046")).shouldBe(Condition.visible).click();
        $(testDataHook("add_product_wi31584")).shouldBe(Condition.visible).click();
        $(testDataHook("add_product_wi55686")).shouldBe(Condition.visible).click();
        $(testDataHook("navigation-shoppinglist")).click();
    }
}