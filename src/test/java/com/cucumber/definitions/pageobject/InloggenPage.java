package com.cucumber.definitions.pageobject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;


public class InloggenPage extends BasePage {

    public InloggenPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    public void verifyPageTitle(String page) {
        String pageTitle = getTitle();
        assertEquals(pageTitle, page);
    }

    public void verifyText(By locator, String text) {
        assertEquals(text, textInputGetText(locator));
    }
}