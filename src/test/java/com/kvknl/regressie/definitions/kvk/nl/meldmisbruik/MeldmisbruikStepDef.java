package com.kvknl.regressie.definitions.kvk.nl.meldmisbruik;

import com.kvknl.regressie.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;


public class MeldmisbruikStepDef extends BaseStepDef {

    private MeldmisbruikPage meldmisbruikPage;

    @PostConstruct
    public void setUp() {
        meldmisbruikPage = PageFactory.initElements(webDriver, MeldmisbruikPage.class);
    }

    @Als("^ik via de home een melding inschiet via een contactformulier")
    public void enter_aanfigte_homelink() {
        meldmisbruikPage.meldMisbruikContactForm();
    }
}
