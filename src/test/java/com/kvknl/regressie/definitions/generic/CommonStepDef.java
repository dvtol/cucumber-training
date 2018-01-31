package com.kvknl.regressie.definitions.generic;

import com.kvknl.regressie.driver.CukeConfigurator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;

public class CommonStepDef extends BaseStepDef {

    private CommonObjPage commonObjPage;
    private CukeConfigurator cukeconfig = new CukeConfigurator();


    @PostConstruct
    public void setUpLogin() {
        commonObjPage = PageFactory.initElements(webDriver, CommonObjPage.class);
    }

    @Given("^the user opens the OR frontoffice application$")
    public void login_kvkor_testenvironment() throws AWTException, IOException {
        commonObjPage.navigateToEnvironment(cukeconfig.targetHostName);
    }

    @Then("^click on the Volgende button$")
    public void clickOnTheNextButton() {
        commonObjPage.clickOnNextButton();
    }

    @Then("^click Add extra group button$")
    public void clickAddExtraGroupObjButton() throws InterruptedException {
        commonObjPage.clickAddExtraGroupObjButton();
    }

    @Then("^click on the Valideren button$")
    public void clickOnTheValiderenButton() throws InterruptedException {
        commonObjPage.clickOnValidateButton();
    }

    @Then("^click on the Opslaan button$")
    public void clickOnTheOpslaanButton() throws InterruptedException {
        commonObjPage.clickOnSaveButton();
    }

    @And("^click on the Delete button$")
    public void clickOnTheDeleteButton() throws InterruptedException {
        commonObjPage.clickOnDeleteButton();
    }

    @Then("^click on the clear button$")
    public void clickOnClearButton() throws InterruptedException {
        commonObjPage.clickOnClearButton();
    }

    @Then("^click add extra trade name button$")
    public void clickAddExtraTradenameButton() throws InterruptedException {
        commonObjPage.clickExtraTradeNameButton();
    }

    @Then("^within \"([^\"]*)\" click takeover or cancel takeover Director button option \"([^\"]*)\"$")
    public void clickTakeOverButton(String page, String chooseoption) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        commonObjPage.takeOverOrCancelDirectorButton(chooseoption);
    }

    @Then("^click add extra telephone number button$")
    public void clickAddExtraTelephoneNumberButton() throws InterruptedException {
        commonObjPage.clickExtraTelephoneNumberButton();
    }

    @Then("^click add extra fax number button$")
    public void clickAddExtraFaxNumberButton() throws InterruptedException {
        commonObjPage.clickExtraFaxNumberButton();
    }

    @And("^within \"([^\"]*)\" the user enters the \"([^\"]*)\" with \"([^\"]*)\"$")
    public void enterDataForField(String page, String id, String input) {
        commonObjPage.verifyPageTitle(page);
        commonObjPage.typeValue(id, input);
        commonObjPage.tab(id);
    }

    @And("^within \"([^\"]*)\" the user chooses for \"([^\"]*)\" the option \"([^\"]*)\"$")
    public void chooseOptionFromDropdownlist(String page, String id, String option) {
        commonObjPage.verifyPageTitle(page);
        commonObjPage.chooseOption(id, option);
    }

    @And("^within \"([^\"]*)\" the user chooses for \"([^\"]*)\" the radiobutton \"([^\"]*)\"$")
    public void clickOnRadiobutton(String page, String id, String radiobutton) {
        commonObjPage.verifyPageTitle(page);
        commonObjPage.chooseRadiobutton(id, radiobutton);
    }

    @And("^within \"([^\"]*)\" the user enters the Geboortedatum with \"([^\"]*)\"$")
    public void enterDateOfBirth(String page, String input){
        commonObjPage.verifyPageTitle(page);
        commonObjPage.typeValueDateOfBirth(input);
    }

    @Then("^the message Validate is succesvol is shown$")
    public void checkTextValidateMessage() {
        String text = "Validatie is succesvol";
        By locater = By.xpath("//div[contains(text(), '"+text+"')]");
        commonObjPage.verifyText(locater, text);
    }

    @And("^within \"([^\"]*)\" the user enters the Naam_berichtenbox with \"([^\"]*)\"$")
    public void enterNaamBerichtenbox(String page, String input) {
        commonObjPage.verifyPageTitle(page);
        By locator = By.xpath("//*[@id='Naam_berichtenbox']/input");
        commonObjPage.typeValueMessageInbox(locator, input);
    }
}