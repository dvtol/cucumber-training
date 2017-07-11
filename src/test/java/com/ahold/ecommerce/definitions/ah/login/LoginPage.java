package com.ahold.ecommerce.definitions.ah.login;


import static com.codeborne.selenide.Selenide.$;

import com.ahold.ecommerce.data.JsonData;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private JsonData testdata = new JsonData();

    @Step("Inloggen AH test-omgeving")
    public void loginAhEnvironment() {

        $(testDataHook("navigation-login")).click();
        $(testDataHook("userNameTextField")).setValue(testdata.JsonData("ah_customer_tst2", "email"));
        $(testDataHook("passwordTextField")).setValue(testdata.JsonData("ah_customer_tst2", "password"));
        $(testDataHook("submitButton")).click();
    }
}