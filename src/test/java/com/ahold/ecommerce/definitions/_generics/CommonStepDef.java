package com.ahold.ecommerce.definitions._generics;

import com.ahold.ecommerce.definitions.ah.login.LoginPage;
import com.ahold.ecommerce.driver.CukeConfigurator;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private LoginPage loginPage;
    CukeConfigurator cukeconfig = new CukeConfigurator();

    @PostConstruct
    public void setUp() {
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    //test for ah.nl test environment tst9
    @Gegeven("^dat gebruiker is ingelogd op een AH test omgeving")
    public void login_ah_testomgeving() {
        loginPage.navigateToEnvironment(cukeconfig.targetHostName);
        loginPage.loginAhEnvironment();
    }
}
