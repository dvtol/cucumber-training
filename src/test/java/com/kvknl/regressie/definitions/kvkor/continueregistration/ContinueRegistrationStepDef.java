package com.kvknl.regressie.definitions.kvkor.continueregistration;


import com.kvknl.regressie.definitions.generic.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class ContinueRegistrationStepDef extends BaseStepDef {

    private ContinueRegistrationPage voortzettenRegistratiePage;

    @PostConstruct
    public void setUp() {
        voortzettenRegistratiePage = PageFactory.initElements(webDriver, ContinueRegistrationPage.class);
    }

    @Als("^ik op een searchterm ga zoeken")
    public void enter_in_searchbox() {
        voortzettenRegistratiePage.enterInSearchBox();
    }
}
