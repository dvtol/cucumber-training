package com.kvknl.regressie.definitions.generic;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CommonObjPage extends BasePage {

    public CommonObjPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    public void clickOnNextButton() {
        buttonClick(By.id("Volgende"));
    }

    public void clickOnSaveButton() {
        buttonClick(By.id("Opslaan"));
    }

    public void verifyPageTitle(String page) {
        By pageTitle = By.xpath("/html/body/div[2]/div[4]/div/h2");
        assertTextInputContainsText(pageTitle, page);
    }

    public void typeValue(String locator, String text) {
        textInputSetText(By.id(locator), text);
    }

    public void chooseOption(String id, String option) {
        dropdownSelectByValue(By.id(id), option);
    }

    public void chooseRadiobutton(String id, String radiobutton) {
        radioButtonVisibleAndSelect(By.id(id+radiobutton));
    }

    public void tab(String id) {
        sendTab(By.id(id));
    }
}