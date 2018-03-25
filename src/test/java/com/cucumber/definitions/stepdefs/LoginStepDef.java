package com.cucumber.definitions.stepdefs;

import com.cucumber.definitions.pageobjects.LoginPage;
import com.cucumber.driver.CukeConfigurator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.awt.*;

public class LoginStepDef extends BaseStepDef {

    private LoginPage loginPage;
    private CukeConfigurator cukeconfig = new CukeConfigurator();

    @PostConstruct
    public void setUpLogin() {
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    @Given("^the user visits the training login page$")
    public void loginCucumberTrainingTestEnv() throws AWTException {
        loginPage.navigateToEnvironment(cukeconfig.targetHostName);
    }

    @When("^the user enters the \"([^\"]*)\" \"([^\"]*)\"")
    public void enterCredentials(String userid, String username) {
        loginPage.typeValue(userid, username);
    }

    @Then("^the user is on the login page$")
    public void verifyOnLoginPage() {
        loginPage.verifyPageTitle("Selenium demo pagina");
    }

    @And("^the user clicks the signin button$")
    public void signIn() {
        loginPage.clickSignInButton();
    }

    @Then("^the user should be on the default landing page of the cucumber website$")
    public void verifyOnCucumberPage() {
        loginPage.verifyPageTitle("Cucumber");
    }

    @Then("^the user should receive the following error message \"([^\"]*)\"$")
    public void verifyErrorMessage(String message) {
        loginPage.verifyText(By.id("loginerror"), message);
    }

    @When("^the user enters the username with \"([^\"]*)\"$")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("^the user enters the password \"([^\"]*)\"$")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("^the user is verifying text \"([^\"]*)\" on the page with id \"([^\"]*)\"$")
    public void theUserIsVerifyingTextOnThePageWithId(String pagetext, String id) {
        loginPage.verifyText(By.id(id), pagetext);
    }

    @And("^the user clicks the verklaring button$")
    public void theUserClicksTheVerklaringButton() {
        loginPage.clickVerklaringButton();
    }

    @And("^the user clicks the second radiobutton$")
    public void theUserClicksTheSecondRadiobutton() {
        loginPage.clickSecondRadiobutton();
    }

    @And("^the user checks the checkbox$")
    public void theUserChecksTheCheckbox() {
        loginPage.checkCheckbox();
    }
}

