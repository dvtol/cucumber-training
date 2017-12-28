package com.kvknl.regressie.definitions.kvkor.newregistration.referencedata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ReferenceDataPage extends BasePage {

    public ReferenceDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het invullen van de referentie informatie wat betreft de onderneming")
    public void fillReferenceInformation() {

        $(By.id("Naam_contactpersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "naam_contactpersoon_referent"));
        $(By.id("E-mailadres_contactpersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "email_contactpersoon_referent"));

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
