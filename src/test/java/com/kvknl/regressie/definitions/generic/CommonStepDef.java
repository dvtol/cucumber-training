package com.kvknl.regressie.definitions.generic;

import com.kvknl.regressie.driver.CukeConfigurator;
import cucumber.api.java.nl.Gegeven;
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

    // navigate and zoeken KvK OR test environment
    @Gegeven("^dat gebruiker is ingelogd op de OR pagina van de KvK")
    public void login_kvkor_testenvironment() throws AWTException, IOException {
        commonObjPage.navigateToEnvironment(cukeconfig.targetHostName);
    }
}