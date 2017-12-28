package com.kvknl.regressie.definitions.kvkor.newregistration.companydata;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CompanyDataPage extends BasePage {

    public CompanyDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het invoeren van de gegevens van de orderneming waaronder de vestiging(en)")
    public void setUpCompanyBranch() {

        $(By.id("Datum_ingang")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "datum_ingang_vestiging"));
        $(By.id("Postcode")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "postcode_vestiging"));
        $(By.id("Huisnummer")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "huisnummer_vestiging"));
        $(By.id("Activiteitomschrijving")).waitUntil(Condition.visible, 5).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "activiteitomschrijving_vestiging"));
        // TODO - fix company trade name
        $(By.id("deletableHandelsnaam_1_*_")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "handelsnaam_vestiging"));
        $(By.id("deletableHandelsnaam_1_*_")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "handelsnaam_vestiging"));
        $(By.id("Hoeveel_personen_werken_er_fulltime_(15_uur_of_meer_per_week)_in_de_onderneming?")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "werkzame_pers_fulltime_vestiging"));
        $(By.id("Hoeveel_personen_werken_er_parttime_(minder_dan_15_uur_per_week)_in_de_onderneming?")).setValue(testdata.JsonData("kvk_orn_nieuwe_inschrijving", "werkzame_pers_parttime_vestiging"));
        $(By.id("Volgende")).click();
        // geen functionarissen aanwezig
        $(By.id("Volgende")).click();
        // geen gemachtigden aanwezig
        $(By.id("Volgende")).click();
        // geen bijlage(n)
        $(By.id("Volgende")).click();
    }
}
