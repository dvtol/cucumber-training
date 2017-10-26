package com.politienl.regressie.definitions.politie.nl.zoeken;


import com.politienl.regressie.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class ZoekenStepDef  extends BaseStepDef {

    private ZoekenPage zoekenPage;

    @PostConstruct
    public void setUp() {
        zoekenPage = PageFactory.initElements(webDriver, ZoekenPage.class);
    }

    @Als("^ik op een searchterm ga zoeken")
    public void enter_in_searchbox() {
        zoekenPage.enterInSearchBox();
    }
}
