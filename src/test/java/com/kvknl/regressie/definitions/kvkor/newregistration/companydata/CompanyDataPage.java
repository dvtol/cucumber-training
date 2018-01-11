package com.kvknl.regressie.definitions.kvkor.newregistration.companydata;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.definitions.generic.BasePage;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CompanyDataPage extends BasePage {

    public CompanyDataPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }
}
