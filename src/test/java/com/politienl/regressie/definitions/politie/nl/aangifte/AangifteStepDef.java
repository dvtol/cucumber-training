package com.politienl.regressie.definitions.politie.nl.aangifte;

import com.politienl.regressie.definitions.politie.nl.meldmisbruik.MeldmisbruikPage;
import com.politienl.regressie.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class AangifteStepDef extends BaseStepDef {

    private AangiftePage aangiftePage;

    @PostConstruct
    public void setUp() {
        aangiftePage = PageFactory.initElements(webDriver, AangiftePage.class);
    }

    @Als("^ik via de home op de link aangifte of melding doen klik")
    public void enter_aanfigte_homelink() {
        aangiftePage.aangifteProcesDigid();
    }
}
