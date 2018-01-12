package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.kvknl.regressie.definitions.generic.BaseStepDef;
import com.kvknl.regressie.definitions.generic.CommonObjPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.fileattachment.FileAttachmentPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.govenordata.GovenorDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.basicdatalegalperson.BasicDataLegalPersonPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.referencedata.ReferenceDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.composeassignment.ComposeAssignmentPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.overview.OverviewPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class NewRegistrationStepDef extends BaseStepDef {

    private ComposeAssignmentPage composeAssignmentPage;
    private BasicDataLegalPersonPage basicDataLegalPersonPage;
    private GovenorDataPage govenorDataPage;
    private ReferenceDataPage referenceDataPage;
    private FileAttachmentPage attachmentPage;
    private OverviewPage overviewPage;
    private CommonObjPage commonObjPage;

    @PostConstruct
    public void setUpNewRegistration() {
        composeAssignmentPage = PageFactory.initElements(webDriver, ComposeAssignmentPage.class);
        basicDataLegalPersonPage = PageFactory.initElements(webDriver, BasicDataLegalPersonPage.class);
        govenorDataPage = PageFactory.initElements(webDriver, GovenorDataPage.class);
        attachmentPage = PageFactory.initElements(webDriver, FileAttachmentPage.class);
        referenceDataPage = PageFactory.initElements(webDriver, ReferenceDataPage.class);
        overviewPage = PageFactory.initElements(webDriver, OverviewPage.class);
        commonObjPage = PageFactory.initElements(webDriver, CommonObjPage.class);
    }

    @Given("^the user is logged in and starts with a new registration with legal form \"([^\"]*)\"$")
    public void selectNewRegistration(String legalForm) {
        composeAssignmentPage.choiceLegalForm(legalForm);
    }

    @When("^the mandatory data is entered$")
    public void fillRegistrationData() throws InterruptedException {
        attachmentPage.addFileAttachment();
        referenceDataPage.fillReferenceInformation();
    }

    @Then("^the user can validate, sign and submit the assignment$")
    public void sumbitRegistration() {
        overviewPage.validateSignAndSumbit();
    }

    @And("^within \"([^\"]*)\" the user enters the unique \"([^\"]*)\" with \"([^\"]*)\"$")
    public void enterUniqueLegalPerson(String page, String id, String abbreviation) {
        commonObjPage.verifyPageTitle(page);
        basicDataLegalPersonPage.typeValueLegalPerson(id, abbreviation);
    }

    @And("^within \"([^\"]*)\" the user chooses for Geboorteland the option \"([^\"]*)\"$")
    public void enterPlaceOfBirth(String page, String input) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        govenorDataPage.typeValuePlaceOfBirth(input);
    }

    @And("^within \"([^\"]*)\" the user enters the Huisnummer with \"([^\"]*)\"$")
    public void enterHousenumber(String page, String input) throws InterruptedException {
        commonObjPage.verifyPageTitle(page);
        govenorDataPage.typeValueHousenumber(input);
    }

    @And("^within \"([^\"]*)\" the user chooses for Functietitel the option \"([^\"]*)\"$")
    public void chooseFunctionTitle(String page, String option) {
        commonObjPage.verifyPageTitle(page);
        govenorDataPage.chooseOption(option);
    }

    @And("^within \"([^\"]*)\" the user chooses for Activiteit \"([^\"]*)\" the option \"([^\"]*)\"$")
    public void chooseActivity(String page, String number, String activity) {
        commonObjPage.verifyPageTitle(page);
        govenorDataPage.chooseActivity(number, activity);
    }

    @And("^the user clicks checkbox to validate the BSN number$")
    public void checkBSNValidation() {
        govenorDataPage.checkBoxBSN();
    }
}
