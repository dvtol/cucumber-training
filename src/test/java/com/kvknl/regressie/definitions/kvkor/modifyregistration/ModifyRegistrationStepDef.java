package com.kvknl.regressie.definitions.kvkor.modifyregistration;

import com.kvknl.regressie.definitions.generic.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;


public class ModifyRegistrationStepDef extends BaseStepDef {

    private ModifyRegistrationPage wijzigRegistratiePage;

    @PostConstruct
    public void setUp() {
        wijzigRegistratiePage = PageFactory.initElements(webDriver, ModifyRegistrationPage.class);
    }

    @Als("^ik via de home een melding inschiet via een contactformulier")
    public void enter_aanfigte_homelink() {
        wijzigRegistratiePage.meldMisbruikContactForm();
    }
}
