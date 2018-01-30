package com.kvknl.regressie.definitions.generic;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;


public class CommonObjPage extends BasePage {

    public CommonObjPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    protected void clickOnNextButton() {
        buttonClick(By.id("Volgende"));
    }

    protected void clickOnSaveButton() throws InterruptedException {
        buttonClick(By.id("Opslaan"));
        Thread.sleep(1000);
    }

    protected void clickOnDeleteButton() throws InterruptedException {
        buttonClick(By.id("Delete"));
    }

    protected void clickOnClearButton() {
        buttonClick(By.id("Schonen"));
    }

    protected void clickOnValidateButton() throws InterruptedException {
        buttonClick(By.id("valideren"));
        Thread.sleep(2000);
    }

    protected void clickAddExtraGroupObjButton() {
        buttonClick(By.id("ObjectGroupAdd"));
    }

    protected void clickExtraTradeNameButton() {
        scrollDownTo("Toevoegen_handelsnaam");
        buttonClick(By.id("Toevoegen_handelsnaam"));
    }

    protected void takeOverOrCancelDirectorButton(String chooseoption) {
        buttonClick(By.xpath("//*[@id=\"Overnemen bestuurder\"]/div/table/tbody/tr/td["+chooseoption+"]/button/span"));
    }

    protected void clickExtraTelephoneNumberButton() {
        buttonClick(By.id("Toevoegen_telefoonnummer"));
    }

    protected void clickExtraFaxNumberButton() {
        buttonClick(By.id("Toevoegen_faxnummer"));
    }

    public void verifyPageTitle(String page) {
        By pageTitle = By.xpath("/html/body/div[2]/div[4]/div/h2");
        assertTextInputContainsText(pageTitle, page);
    }

    protected void typeValue(String locator, String text) {
        textInputSetText(By.id(locator), text);
    }

    protected void typeValueMessageInbox(By locator, String text){
        textInputSetText(locator, text);
    }

    protected void chooseOption(String id, String option) {
        dropdownSelectByValue(By.id(id), option);
    }

    protected void chooseRadiobutton(String id, String radiobutton) {
        radioButtonVisibleAndSelect(By.id(id+radiobutton));
    }

    protected void tab(String id) {
        sendTab(By.id(id));
    }

    protected void typeValueDateOfBirth(String input) {
        By locator = By.xpath("//*[@id='Geboortedatum']/input");
        textInputSetText(locator, input);
        sendTab(locator);
    }

    protected void verifyText(By locator, String text) {
        assertEquals(text, textInputGetText(locator));
    }
}