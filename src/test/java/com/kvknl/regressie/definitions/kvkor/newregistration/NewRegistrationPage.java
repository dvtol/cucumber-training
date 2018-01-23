package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.definitions.generic.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class NewRegistrationPage extends BasePage {

    private static final int begin = 100000;
    private static final int end = 999999;

    public NewRegistrationPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("new kvk registration")

    // choose legal type
    public void choiceLegalForm(String legalForm) {
        Configuration.timeout = 15000;
        $(By.id("Type_opgave")).click();
        $(By.xpath("//*[@id=\"Type_opgave\"]/option[1]")).click();
        dropdownSelectByValue(By.id("Rechtsvorm"), legalForm);
        $(By.id("Volgende")).click();
    }

    // choose legal type person
    public void typeValueLegalPerson(String locator, String abbreviation) {
        String nameLegalPerson = "Tester org " + new Random().nextInt(end - begin) + " " + abbreviation;
        textInputSetText(By.id(locator), nameLegalPerson);
        System.out.println("Naam Rechtspersoon = " + nameLegalPerson);
    }

    // validate and submit buttons
    public void validateSignAndSumbit() {
        $(By.id("valideren")).click();
        $(By.id("Opslaan")).click();
    }

    // to fill place of birth
    public void typeValuePlaceOfBirth(String input) throws InterruptedException {
        By locator = By.id("Geboorteland");
        Thread.sleep(1000);
        dropdownSelectByValue(locator, input);
    }

    // to fill housenumber
    public void typeValueHousenumber(String text) throws InterruptedException {
        By locator = By.id("Huisnummer");
        textInputSetText(locator, text);
        sendTab(locator);
        Thread.sleep(1000);
    }

    // option to choose a specific value
    public void chooseOption(String option) {
        By locator = By.id("RtListBox");
        dropdownSelectByValue(locator, option);
    }

    // option to choose activity
    public void chooseActivity(String number, String activity) {
        By locator = By.xpath("(//*[@id='RtListBox'])["+number+"]");
        dropdownSelectByValue(locator, activity);
    }

    // validate check for BSN number
    public void checkBoxBSN() {
        By locator = By.id("Vanya Ebben");
        checkBoxVisibleAndCheck(locator);
    }

    // TODO
    public void addMultipleofficial() {

    }

    // TODO
    public void addMultipleLocation() {

    }

    // TODO
    public void openLocation() {

    }

    // TODO
    public void deleteLocation() {

    }

    // TODO
    public void extraTradenameVisitAddress() {

    }

    // TODO
    public void extraPhoneNumberVisitAddress() {

    }

    // TODO
    public void extraFaxNumberVisitAddress() {

    }

    // TODO
    public void dataAuthorizedRepresentitive() {

    }

    // TODO
    public void deleteAuthorizedRepresentitive() {

    }
}

