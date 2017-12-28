package com.kvknl.regressie.definitions._generics;

import com.kvknl.regressie.driver.CukeConfigurator;
import cucumber.api.java.nl.Gegeven;
import lombok.experimental.var;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static java.awt.SystemColor.window;

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