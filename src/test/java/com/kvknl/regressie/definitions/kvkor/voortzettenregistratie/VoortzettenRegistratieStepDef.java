package com.kvknl.regressie.definitions.kvkor.voortzettenregistratie;


import com.kvknl.regressie.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class VoortzettenRegistratieStepDef extends BaseStepDef {

    private VoortzettenRegistratiePage voortzettenRegistratiePage;

    @PostConstruct
    public void setUp() {
        voortzettenRegistratiePage = PageFactory.initElements(webDriver, VoortzettenRegistratiePage.class);
    }

    @Als("^ik op een searchterm ga zoeken")
    public void enter_in_searchbox() {
        voortzettenRegistratiePage.enterInSearchBox();
    }
}
