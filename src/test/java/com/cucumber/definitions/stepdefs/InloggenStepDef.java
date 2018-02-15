package com.cucumber.definitions.stepdefs;

import com.cucumber.definitions.pageobject.InloggenPage;
import com.cucumber.driver.CukeConfigurator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.awt.*;

public class InloggenStepDef extends BaseStepDef {

    private InloggenPage inloggenPage;
    private CukeConfigurator cukeconfig = new CukeConfigurator();

    @PostConstruct
    public void setUpLogin() {
        inloggenPage = PageFactory.initElements(webDriver, InloggenPage.class);
    }

    @Given("^de gebruiker opent de inloggen pagina$")
    public void loginCucumberTrainingTestEnv() throws AWTException {
        inloggenPage.navigateToEnvironment(cukeconfig.targetHostName);
    }

    @Given("^the user has opened a browser$")
    public void theUserHasOpenedABrowser() {
    }

    @When("^the user enters \"([^\"]*)\" in the browser$")
    public void openPage(String url) throws AWTException {
        inloggenPage.navigateToEnvironment(url);
    }

    @Then("^the user is on the login page$")
    public void verifyOnLoginPage() {
        inloggenPage.verifyPageTitle("Selenium demo pagina");
    }
}

