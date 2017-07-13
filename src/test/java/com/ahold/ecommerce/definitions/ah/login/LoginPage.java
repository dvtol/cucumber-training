package com.ahold.ecommerce.definitions.ah.login;


import static com.codeborne.selenide.Selenide.$;
import com.ahold.ecommerce.data._JsonData;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Inloggen AH test-omgeving")
    public void loginAhEnvironment() {

        Configuration.timeout = 8000;

        // login AH home
        $(testDataHook(testdata.JsonData("webelements_login", "Inloggen Home"))).click();

        // login with username and password
        $(testDataHook(testdata.JsonData("webelements_login", "email_element")))
                .setValue(testdata.JsonData("ah_customer_elcheapo", "email"));
        $(testDataHook(testdata.JsonData("webelements_login", "wachtwoord_element")))
                .setValue(testdata.JsonData("ah_customer_elcheapo", "wachtwoord"));

        // click button to login
        $(testDataHook(testdata.JsonData("webelements_login", "Inloggen"))).click();
    }
}