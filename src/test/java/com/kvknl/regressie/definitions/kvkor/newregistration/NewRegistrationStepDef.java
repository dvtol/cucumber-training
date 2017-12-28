package com.kvknl.regressie.definitions.kvkor.newregistration;

import com.kvknl.regressie.definitions._generics.BaseStepDef;
import com.kvknl.regressie.definitions.kvkor.newregistration.govenordata.GovenorDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.basicdatalegalperson.BasicDataLegalPersonPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.companydata.CompanyDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.referencedata.ReferenceDataPage;
import com.kvknl.regressie.definitions.kvkor.newregistration.composeassignment.ComposeAssignmentPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.Bijlagen.BijlagenPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.overzicht.OverzichtPage;
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
    private BijlagenPage bijlagenPage;
    private OverzichtPage overzichtPage;

    @PostConstruct
    public void setUpNewRegistration() {
        composeAssignmentPage = PageFactory.initElements(webDriver, ComposeAssignmentPage.class);
        basicDataLegalPersonPage = PageFactory.initElements(webDriver, BasicDataLegalPersonPage.class);
        govenorDataPage = PageFactory.initElements(webDriver, GovenorDataPage.class);
        companyDataPage = PageFactory.initElements(webDriver, CompanyDataPage.class);
        bijlagenPage = PageFactory.initElements(webDriver, BijlagenPage.class);
        referenceDataPage = PageFactory.initElements(webDriver, ReferenceDataPage.class);
        overzichtPage = PageFactory.initElements(webDriver, OverzichtPage.class);
    }

    @Als("^de gebruiker voor een nieuwe inschrijving met als rechtsvorm BV")
    public void selectNewRegistration() {
        composeAssignmentPage.choiceLegalForm();
    }

    @En("^de benodigde en verplichte gegevens zijn opgevoerd")
    public void fillRegistrationData() {
        basicDataLegalPersonPage.basicDataLegalPerson();
        govenorDataPage.govenorData();
        companyDataPage.setUpCompanyBranch();
        bijlagenPage.addAttachments();
        referenceDataPage.fillReferenceInformation();
    }

    @Dan("^kan de gebruiker de opgave valideren, ondertekenen en indienen")
    public void valideren_ondertekenen_indienen() {
        overzichtPage.ValiderenOndertekenenIndienen();
    }
}
