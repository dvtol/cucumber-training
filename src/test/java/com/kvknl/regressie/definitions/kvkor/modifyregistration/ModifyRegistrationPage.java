package com.kvknl.regressie.definitions.kvkor.modifyregistration;

import com.codeborne.selenide.Configuration;
import com.kvknl.regressie.definitions._generics.BasePage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.kvknl.regressie.data._JsonData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class ModifyRegistrationPage extends BasePage {

    public ModifyRegistrationPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    private _JsonData testdata = new _JsonData();

    @Step("Meldmisbruik via contactformulier")
    protected void meldMisbruikContactForm() {

        Configuration.timeout = 15000;

        $(By.id("aangifte-melding")).click();
        $(By.xpath("//*[@id=\"linkspagina\"]/dl/dd[7]/a")).click();
        $(By.xpath("//*[@id=\"link-anders\"]/ul/li[5]/a")).click();
        $(By.id("field-1-2")).setValue(testdata.JsonData("webelements_contact", "Plaatsnaam Voorval")).submit();
        $(By.id("field-1-12")).setValue(testdata.JsonData("webelements_contact", "Emailadres")).submit();
        $(By.id("submit_button")).click();
        $(By.id("submit_button")).click();
        $("#formulier-container > div > div > h3").shouldHave(text("Het formulier is verzonden"));
    }
}