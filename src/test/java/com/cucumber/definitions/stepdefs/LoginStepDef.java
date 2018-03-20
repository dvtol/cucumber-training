package com.cucumber.definitions.stepdefs;

import com.cucumber.definitions.pageobjects.LoginPage;
import com.cucumber.driver.CukeConfigurator;
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

    @Then("^the user is on the login page$")
    public void verifyOnLoginPage() {
        loginPage.verifyPageTitle("Selenium demo pagina");
    }

    @When("^the user enters the username with \"([^\"]*)\"$")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }
}

