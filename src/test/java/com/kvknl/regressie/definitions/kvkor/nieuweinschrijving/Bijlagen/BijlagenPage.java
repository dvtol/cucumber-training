package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.Bijlagen;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions._generics.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BijlagenPage extends BasePage {

    public BijlagenPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // JSON obj for GUI data
    private _JsonData testdata = new _JsonData();

    @Step("het toevoegen van de verplichte bijlagen")
    public void ToevoegenBijlagen() {

        dropdownSelectByValue((By.id("Type_bijlage")), "Datacard Test Tester Getest van van Dongen (verplicht)");
        findElement(By.xpath("//*[@id='Bijlage_1']/input")).sendKeys("C:\\work\\GIT\\kvk-or-regressie\\src\\test\\resources\\bijlagen\\Datacard.pdf");
        buttonClick(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[5]/button"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdownSelectByValue((By.id("Type_bijlage")), "Akte van oprichting (verplicht)");
        findElement(By.xpath("//*[@id='Bijlage_1']/input")).sendKeys("C:\\work\\GIT\\kvk-or-regressie\\src\\test\\resources\\bijlagen\\Akte van oprichting.pdf");
        buttonClick(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[5]/button"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("Opslaan")).click();
        $(By.id("Volgende")).click();
    }
}
