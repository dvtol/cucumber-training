package com.kvknl.regressie.definitions.kvkor.newregistration.govenordata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions.generic.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class GovenorDataPage extends BasePage {

    public GovenorDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het invullen van de gegevens van één of meerdere bestuurders")

    public void typeValuePlaceOfBirth(String input) throws InterruptedException {
        By locator = By.id("Geboorteland");
        Thread.sleep(1000);
        dropdownSelectByValue(locator, input);
    }

    public void typeValueHousenumber(String text) throws InterruptedException {
        By locator = By.id("Huisnummer");
        textInputSetText(locator, text);
        sendTab(locator);
        Thread.sleep(1000);
    }

    public void choosOption(String option) {
        By locator = By.id("RtListBox");
        dropdownSelectByValue(locator, option);
    }

    public void checkBoxBSN() {
        By locator = By.id("Vanya Ebben");
        checkBoxVisibleAndCheck(locator);
    }
}
