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
    public void addFileAttachment(String attachment, String option) throws InterruptedException {

        final String requiredfile = "//*[@id='Bijlage_1']/input";

        dropdownSelectByValue((By.id("Type_bijlage")), option);
        findElement(By.xpath(requiredfile)).sendKeys(AttachmentPage.loadAttachment(attachment));
        buttonClick(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[5]/button"));
        Thread.sleep(1000);
    }
}