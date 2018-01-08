package com.kvknl.regressie.definitions.googletest;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.support.PageFactory;
import com.kvknl.regressie.definitions.generic.BaseStepDef;

import javax.annotation.PostConstruct;

public class GoogleTestStepDef extends BaseStepDef {

    private GoogleTestPage googleTestPage;

    @PostConstruct
    public void setUp() {
        googleTestPage = PageFactory.initElements(webDriver, GoogleTestPage.class);
    }

	@Gegeven("^open google$")
	public void open_google() {
        googleTestPage.navigateToGoogle();
	}

	@Als("^enter \"([^\"]*)\" in searchbox$")
	public void enter_in_searchbox(final String search) {
        googleTestPage.enterInSearchBox(search);
	}

	@Dan("^I should get result as \"([^\"]*)\"$")
	public void I_should_get_correct_result(final String verwachteResultaat) {
        googleTestPage.controleerVerwachteWaarde(verwachteResultaat);
	}

	@Als("^enter testdata in searchbox$")
	public void enter_testdata_in_searchbox() {
		googleTestPage.enterTestdataInSearchBox();
	}

}