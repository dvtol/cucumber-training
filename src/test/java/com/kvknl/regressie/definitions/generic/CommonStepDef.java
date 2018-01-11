package com.kvknl.regressie.definitions.generic;

import com.kvknl.regressie.driver.CukeConfigurator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
    public void clickOnTheVolgendeButton() {
        commonObjPage.clickOnNextButton();
    }

    @Then("^click on the Opslaan button$")
    public void clickOnTheOpslaanButton() {
        commonObjPage.clickOnSaveButton();
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
}