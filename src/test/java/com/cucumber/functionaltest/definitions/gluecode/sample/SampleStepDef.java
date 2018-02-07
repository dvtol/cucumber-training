package com.cucumber.functionaltest.definitions.gluecode.sample;


import com.cucumber.functionaltest.definitions.generic.BaseStepDef;
import cucumber.api.java.en.When;

public class SampleStepDef extends BaseStepDef {

    //private SamplePage SamplePage;

    /*
    @PostConstruct
    public void setUp() {
        SamplePage = PageFactory.initElements(webDriver, SamplePage.class);
    }
    */

    @When("^user search a sample")
    public void sampleSearch() {
    }
}
