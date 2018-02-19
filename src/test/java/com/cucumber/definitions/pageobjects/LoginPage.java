package com.cucumber.definitions.pageobjects;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    public void typeValue(String locator, String text) {
        textInputSetText(By.id(locator), text);
    }

    public void signInButton(String locator) {
        buttonClick(By.id(locator));
    }

    public void verifyPageTitle(String page) {
        String pageTitle = getTitle();
        assertEquals(pageTitle, page);
    }

    public void verifyText(By locator, String text) {
        assertEquals(text, textInputGetText(locator));
    }
}