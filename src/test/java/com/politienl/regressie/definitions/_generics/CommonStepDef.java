package com.politienl.regressie.definitions._generics;

import com.politienl.regressie.driver.CukeConfigurator;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private CommonObjPage commonObjPage;
    private CukeConfigurator cukeconfig = new CukeConfigurator();


    @PostConstruct
    public void setUpLogin() {
        commonObjPage = PageFactory.initElements(webDriver, CommonObjPage.class);
    }

    // navigate and zoeken politie.nl test environment
    @Gegeven("^dat gebruiker is ingelogd op de homepage van politie.nl")
    public void login_politienl_testomgeving() {
        commonObjPage.navigateToEnvironment(cukeconfig.targetHostName);
    }
}