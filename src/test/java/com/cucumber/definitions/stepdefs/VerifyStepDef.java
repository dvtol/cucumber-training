package com.cucumber.definitions.stepdefs;

import com.cucumber.definitions.pageobjects.VerifyPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class VerifyStepDef extends BaseStepDef {

    private VerifyPage verifyPage;

    @PostConstruct
    public void setUpLogin() {
        verifyPage = PageFactory.initElements(webDriver, VerifyPage.class);
    }

    @And("^the user is verifying text \"([^\"]*)\" on the page$")
    public void verifyPageText(String pagetext) {
        verifyPage.verifyText(By.id("slogan"), pagetext);
    }

    @And("^the user is verifying pagetitle text on the page$")
    public void verifyPageTitleText() {
        verifyPage.verifyPageTitle("Selenium demo pagina");
    }
}

