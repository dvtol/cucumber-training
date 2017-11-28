package com.politienl.regressie.definitions.politie.nl.zoeken;

import com.politienl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.politienl.regressie.driver.DatabaseServices;
import com.politienl.regressie.driver.TestDataServices;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ZoekenPage extends BasePage {

    public ZoekenPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("Zoek functionaliteit op specifieke termen")
    protected void enterInSearchBox() {
        Configuration.timeout = 15000;

        /* VOORBEELD */
        DatabaseServices mongoDB = new DatabaseServices("elementDB", "searchData");        // TODO: Waar gaan we dit initieren?
        TestDataServices testService = new TestDataServices(mongoDB);                    // TODO: Waar gaan we dit initieren?

        /* TEST MET MEERDERE VALUES IN HETZELFDE VELD. HANDIG VOOR ZELFDE TEST MET VERSCHILLENDE DATA */
        List<String> dataLijst = testService.getTestDataResultListByAttributeAndValue("name", "searchBoxData", "boxData");
        for (String data : dataLijst) {
            $(By.id("searchinput")).setValue(data).submit();
        }

        /* SINGLE DATA TEST */
        $(By.id("searchinput")).setValue(testService.getTestDataByAttributeAndValue("name", "searchBoxDatab", "boxData")).submit();
        /* EINDE VOORBEELD */
    }
}