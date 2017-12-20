package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.bestuurderdata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BestuurderDataPage extends BasePage {

    public BestuurderDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het invullen van de gegevens van één of meerdere bestuurders")
    public void GegevensBestuurder() {

        $(By.id("Datum_waarop_de_functionaris_in_functie_is_getreden")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "datum_intreden_functionaris"));
        $(By.id("Achternaam")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "achternaam_bestuurder"));
        $(By.id("Voorna(a)m(en)_(voluit)")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "voornamen_voluit_bestuurder"));
        $(By.id("Tussenvoegsel(s)")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "tussenvoegsels_bestuuder"));
        $(By.xpath("//*[@id=\"Geboortedatum\"]/input")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "geboortedatum_bestuuder"));
        $(By.id("Postcode")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "postcode_prive_bestuurder"));
        $(By.id("Huisnummer")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "huisnummer_prive_bestuurder"));
        $(By.id("Volgende")).click();
    }
}
