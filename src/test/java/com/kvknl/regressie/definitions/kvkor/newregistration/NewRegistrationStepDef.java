package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.kvknl.regressie.definitions.generic.BaseStepDef;
import com.kvknl.regressie.definitions.kvkor.newregistration.fileattachment.FileAttachmentPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.govenordata.GovenorDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.basicdatalegalperson.BasicDataLegalPersonPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.companydata.CompanyDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.referencedata.ReferenceDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.composeassignment.ComposeAssignmentPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.overview.OverviewPage;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
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

    @PostConstruct
    public void setUpNewRegistration() {
        composeAssignmentPage = PageFactory.initElements(webDriver, ComposeAssignmentPage.class);
        basicDataLegalPersonPage = PageFactory.initElements(webDriver, BasicDataLegalPersonPage.class);
        govenorDataPage = PageFactory.initElements(webDriver, GovenorDataPage.class);
        companyDataPage = PageFactory.initElements(webDriver, CompanyDataPage.class);
        attachmentPage = PageFactory.initElements(webDriver, FileAttachmentPage.class);
        referenceDataPage = PageFactory.initElements(webDriver, ReferenceDataPage.class);
        overviewPage = PageFactory.initElements(webDriver, OverviewPage.class);
    }

    @Als("^de gebruiker voor een nieuwe inschrijving met als rechtsvorm BV")
    public void selectNewRegistration() {
        composeAssignmentPage.choiceLegalForm();
    }

    @En("^de benodigde en verplichte gegevens zijn opgevoerd")
    public void fillRegistrationData() throws InterruptedException {
        basicDataLegalPersonPage.basicDataLegalPerson();
        govenorDataPage.govenorData();
        companyDataPage.setUpCompanyBranch();
        attachmentPage.addFileAttachment();
        referenceDataPage.fillReferenceInformation();
    }

    @Dan("^kan de gebruiker de opgave valideren, ondertekenen en indienen")
    public void sumbitRegistration() {
        overviewPage.validateSignAndSumbit();
    }
}
