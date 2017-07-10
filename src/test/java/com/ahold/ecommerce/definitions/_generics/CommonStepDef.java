package com.ahold.ecommerce.definitions._generics;

import com.ahold.ecommerce.definitions.ah.inloggen.LoginPage;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private LoginPage loginPage;

    @PostConstruct
    public void setUp() {
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    //test for ah.nl test environment tst9
    @Gegeven("^dat gebruiker is ingelogd op AH test omgeving \"([^\"]*)\"$")
    public void login_ah_testomgeving(String targetHostName) {
        loginPage.navigateToEnvironment(targetHostName);
        loginPage.loginAhEnvironment();
    }
}
