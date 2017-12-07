package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.bestuurderdata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
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

        // het invoeren van bestuurder(s) data

    }
}
