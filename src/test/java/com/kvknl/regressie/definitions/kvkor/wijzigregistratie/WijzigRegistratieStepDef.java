package com.kvknl.regressie.definitions.kvkor.wijzigregistratie;

import com.kvknl.regressie.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;


public class WijzigRegistratieStepDef extends BaseStepDef {

    private WijzigRegistratiePage wijzigRegistratiePage;

    @PostConstruct
    public void setUp() {
        wijzigRegistratiePage = PageFactory.initElements(webDriver, WijzigRegistratiePage.class);
    }

    @Als("^ik via de home een melding inschiet via een contactformulier")
    public void enter_aanfigte_homelink() {
        wijzigRegistratiePage.meldMisbruikContactForm();
    }
}
