package com.kvknl.regressie.definitions.kvkor.newregistration.fileattachment;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions.generic.BasePage;
import com.kvknl.regressie.definitions.generic.attachments.AttachmentPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class FileAttachmentPage extends BasePage {

    public FileAttachmentPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("het toevoegen van de verplichte bijlagen")
    public void addFileAttachment() {

        final String requiredfile = "//*[@id='Bijlage_1']/input";

        // adding required attachments
        dropdownSelectByValue((By.id("Type_bijlage")), "Datacard Test Tester Getest van van Dongen (verplicht)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.xpath(requiredfile)).sendKeys(AttachmentPage.loadAttachment("Datacard.pdf"));
        dropdownSelectByValue((By.id("Type_bijlage")), "Akte van oprichting (verplicht)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.xpath(requiredfile)).sendKeys(AttachmentPage.loadAttachment("Akte van oprichting.pdf"));
        $(By.id("Opslaan")).click();
        $(By.id("Volgende")).click();
    }
}
