package com.kvknl.regressie.definitions.kvkor.newregistration.basicdatalegalperson;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions.generic.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class BasicDataLegalPersonPage extends BasePage {

    public BasicDataLegalPersonPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    private static final int begin = 100000;
    private static final int end = 999999;

    @Step("fill basic data en kapitaalgegevens van de rechtspersoon")
    public void typeValueLegalPerson(String locator, String abbreviation) {
        String nameLegalPerson = testdata.JsonData("kvk_orn_nieuwe_inschrijving", "naam_rechtspersoon") + " "+ new Random().nextInt(end - begin)+" "+abbreviation;
        textInputSetText(By.id(locator), nameLegalPerson);
        System.out.println("Naam Rechtspersoon = "+nameLegalPerson);
    }
}
