package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.kvknl.regressie.definitions.generic.BaseStepDef;
import com.kvknl.regressie.definitions.generic.CommonObjPage;
import com.kvknl.regressie.definitions.generic.attachments.AttachmentPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class NewRegistrationStepDef extends BaseStepDef {

    private AttachmentPage attachmentPage;
    private CommonObjPage commonObjPage;
    private NewRegistrationPage newRegistrationPage;

    @PostConstruct
    public void setUpNewRegistration() {
        attachmentPage = PageFactory.initElements(webDriver, AttachmentPage.class);
        commonObjPage = PageFactory.initElements(webDriver, CommonObjPage.class);
        newRegistrationPage = PageFactory.initElements(webDriver, NewRegistrationPage.class);
    }

    @Given("^the user is logged in and starts with a new registration with legal form \"([^\"]*)\"$")
    public void selectNewRegistration(String legalForm) {
        newRegistrationPage.choiceLegalForm(legalForm);
    }

    @Then("^the user can validate, sign and submit the assignment$")
    public void sumbitRegistration() {
        newRegistrationPage.validateSignAndSumbit();
    }

    @And("^within \"([^\"]*)\" the user enters the unique \"([^\"]*)\" with \"([^\"]*)\"$")
    public void enterUniqueLegalPerson(String page, String id, String abbreviation) {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.typeValueLegalPerson(id, abbreviation);
    }

    @And("^within \"([^\"]*)\" the user chooses for Geboorteland the option \"([^\"]*)\"$")
    public void enterPlaceOfBirth(String page, String input) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.typeValuePlaceOfBirth(input);
    }

    @And("^within \"([^\"]*)\" the user enters the Huisnummer with \"([^\"]*)\"$")
    public void enterHousenumber(String page, String input) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.typeValueHousenumber(input);
    }

    @And("^within \"([^\"]*)\" the user chooses for Functietitel the option \"([^\"]*)\"$")
    public void chooseFunctionTitle(String page, String option) {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.chooseOption(option);
    }

    @And("^within \"([^\"]*)\" the user chooses for Activiteit \"([^\"]*)\" the option \"([^\"]*)\"$")
    public void chooseActivity(String page, String number, String activity) {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.chooseActivity(number, activity);
    }

    @And("^within \"([^\"]*)\" the user chooses for the added Director \"([^\"]*)\"$")
    public void chooseDirector(String page, String number) {
        commonObjPage.verifyPageTitle(page);
        newRegistrationPage.chooseDirector(number);
    }

    @And("^the user clicks checkbox to validate the BSN number$")
    public void checkBSNValidation() {
        newRegistrationPage.checkBoxBSN();
    }

    @And("^within \"([^\"]*)\" the user uploads the attachment \"([^\"]*)\" for \"([^\"]*)\"$")
    public void uploadAttachment(String page, String attachment, String option) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        attachmentPage.addFileAttachment(attachment, option);
    }
}
