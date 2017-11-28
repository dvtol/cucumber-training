package com.kvknl.regressie.definitions._generics;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;


public class CommonObjPage extends BasePage {

    public CommonObjPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }
}