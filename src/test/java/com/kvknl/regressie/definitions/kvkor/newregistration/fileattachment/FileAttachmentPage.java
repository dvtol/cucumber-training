package com.kvknl.regressie.definitions.kvkor.newregistration.fileattachment;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions.generic.BasePage;
import com.kvknl.regressie.definitions.generic.attachments.AttachmentPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class FileAttachmentPage extends BasePage {

    public FileAttachmentPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("het toevoegen van de verplichte bijlagen")
    public void addFileAttachment() {

        dropdownSelectByValue((By.id("Type_bijlage")), "Datacard Test Tester Getest van van Dongen (verplicht)");
        findElement(By.xpath("//*[@id='Bijlage_1']/input")).sendKeys(AttachmentPage.loadAttachment("Datacard.pdf"));
        buttonClick(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[5]/button"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdownSelectByValue((By.id("Type_bijlage")), "Akte van oprichting (verplicht)");
        findElement(By.xpath("//*[@id='Bijlage_1']/input")).sendKeys(AttachmentPage.loadAttachment("Akte van oprichting.pdf"));
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
