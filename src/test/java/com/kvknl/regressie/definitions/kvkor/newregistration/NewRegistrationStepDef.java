package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.kvknl.regressie.definitions.generic.BaseStepDef;
import com.kvknl.regressie.definitions.generic.CommonObjPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.fileattachment.FileAttachmentPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.govenordata.GovenorDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.basicdatalegalperson.BasicDataLegalPersonPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.companydata.CompanyDataPage;
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
    private CompanyDataPage companyDataPage;
    private ReferenceDataPage referenceDataPage;
    private FileAttachmentPage attachmentPage;
    private OverviewPage overviewPage;
    private CommonObjPage commonObjPage;

    @PostConstruct
    public void setUpNewRegistration() {
        composeAssignmentPage = PageFactory.initElements(webDriver, ComposeAssignmentPage.class);
        basicDataLegalPersonPage = PageFactory.initElements(webDriver, BasicDataLegalPersonPage.class);
        govenorDataPage = PageFactory.initElements(webDriver, GovenorDataPage.class);
        companyDataPage = PageFactory.initElements(webDriver, CompanyDataPage.class);
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
        basicDataLegalPersonPage.basicDataLegalPerson();
        govenorDataPage.govenorData();
        companyDataPage.setUpCompanyBranch();
        attachmentPage.addFileAttachment();
        referenceDataPage.fillReferenceInformation();
    }

    @Then("^the user can validate, sign and submit the assignment$")
    public void sumbitRegistration() {
        overviewPage.validateSignAndSumbit();
    }

    @And("^within \"([^\"]*)\" the user enters the unique \"([^\"]*)\"$")
    public void enterUniqueLegalPerson(String page, String id) {
        commonObjPage.verifyPageTitle(page);
        basicDataLegalPersonPage.typeValueLegalPerson(id);
    }
}
