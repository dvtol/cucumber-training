package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.basisgegevensrechtspersoon;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class BasisgegevensRechtspersoonPage extends BasePage {

    public BasisgegevensRechtspersoonPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    private static final int begin = 100000;
    private static final int end = 999999;

    @Step("het vullen van de basis en kapitaalgegevens van de rechtspersoon")
    public void BasisgegevensRechtspersoon() {

        // vullen verplichte basisgegevens
        $(By.id("Naam_rechtspersoon")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "naam_rechtspersoon") + new Random().nextInt(end - begin));
        $(By.id("Zetel")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "zetel"));
        $(By.id("Datum_akte_van_oprichting")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "datum_akte_van_oprichting"));
        $(By.xpath("//*[@id=\"Zetel\"]")).click();
        $(By.id("Datum_ingang")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "datum_ingang"));
        $(By.xpath("//*[@id=\"Zetel\"]")).click();
        $(By.xpath("//*[@id=\"Bestuursmodel\"]/option[2]")).click();
        $(By.id("Opslaan")).click();
        $(By.id("Volgende")).click();

        // vullen verplichte kapitaalgegevens
        $(By.id("Geplaatst_kapitaal")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "geplaatst_kapitaal"));
        $(By.id("Gestort_kapitaal")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "gestort_kapitaal"));
        $(By.id("Opslaan")).click();
        $(By.id("Volgende")).click();
    }
}
