package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.referentiedata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ReferentieDataPage extends BasePage {

    public ReferentieDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het invullen van de referentie informatie wat betreft de onderneming")
    public void VulReferentieInformatie() {

        $(By.id("Naam_contactpersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "naam_contactpersoon_referent"));
        $(By.id("E-mailadres_contactpersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "email_contactpersoon_referent"));
        $(By.id("Telefoonnummer_contactpersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "telefoonnummer_contactpersoon_referent"));
        $(By.id("Uw_referentie")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "uwreferentie_contactpersoon_referent"));
        $(By.id("Aanvullende_informatie")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "aanvullende_contactpersoon_referent"));
        $(By.id("Opslaan")).click();
        $(By.id("Volgende")).click();

    }
}
