package com.cucumber.functionaltest.definitions.gluecode.sample;

import com.cucumber.functionaltest.definitions.generic.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SamplePage extends BasePage {

    public SamplePage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("Put sample steps here!")
    protected void todoSample() {
        Configuration.timeout = 15000;
    }
}