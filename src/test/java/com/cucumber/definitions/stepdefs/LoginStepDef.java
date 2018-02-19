package com.cucumber.definitions.stepdefs;

import com.cucumber.definitions.pageobjects.LoginPage;
import com.cucumber.driver.CukeConfigurator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
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
    public void openPage(String userid, String username) {
        loginPage.typeValue(userid, username);
    }

    @Then("^the user is on the login page$")
    public void verifyOnLoginPage() {
        loginPage.verifyPageTitle("Selenium demo pagina");
    }

    @And("^the user clicks the signin button$")
    public void signIn() {
        loginPage.signInButton("SubmitCreds");
    }
}

