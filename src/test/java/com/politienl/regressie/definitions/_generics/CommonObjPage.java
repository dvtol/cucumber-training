package com.politienl.regressie.definitions.politie.nl.meldmisbruik;


import static com.codeborne.selenide.Selenide.$;
import com.politienl.regressie.data._JsonData;
import com.politienl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MeldmisbruikPage extends BasePage {

    public MeldmisbruikPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Inloggen politie.nl test-omgeving")
    public void loginAhEnvironment() {

        Configuration.timeout = 15000;

        // zoeken AH meldmisbruik
        $(testDataHook(testdata.JsonData("webelements_login", "Inloggen Home"))).click();

        // zoeken with username and password
        $(testDataHook(testdata.JsonData("webelements_login", "email_element")))
                .setValue(testdata.JsonData("nl_customer_politie", "email"));
        $(testDataHook(testdata.JsonData("webelements_login", "wachtwoord_element")))
                .setValue(testdata.JsonData("nl_customer_politie", "wachtwoord"));

        // click button to zoeken
        $(testDataHook(testdata.JsonData("webelements_login", "Inloggen"))).click();
    }
}