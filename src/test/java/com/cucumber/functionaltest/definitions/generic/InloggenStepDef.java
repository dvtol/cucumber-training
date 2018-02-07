package com.cucumber.functionaltest.definitions.generic;

import com.cucumber.functionaltest.driver.CukeConfigurator;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.awt.*;

public class InloggenStepDef extends BaseStepDef {

    private CommonObjPage commonObjPage;
    private CukeConfigurator cukeconfig = new CukeConfigurator();

    @PostConstruct
    public void setUpLogin() {
        commonObjPage = PageFactory.initElements(webDriver, CommonObjPage.class);
    }

    @Given("^de gebruiker opent de inloggen pagina$")
    public void loginCucumberTrainingTestEnv() throws AWTException {
        commonObjPage.navigateToEnvironment(cukeconfig.targetHostName);
    }


}

