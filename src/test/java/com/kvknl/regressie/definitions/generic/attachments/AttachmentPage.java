package com.kvknl.regressie.definitions.generic.attachments;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.definitions.generic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class AttachmentPage extends BasePage {

    private static final String folder = "bijlagen/";

    public AttachmentPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    // adding attachment to the assignment
    public void addFileAttachment(String attachment, String option) throws InterruptedException {

        final String requiredfile = "//*[@id='Bijlage_1']/input";

        dropdownSelectByValue((By.id("Type_bijlage")), option);
        findElement(By.xpath(requiredfile)).sendKeys(AttachmentPage.loadAttachment(attachment));
        buttonClick(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[5]/button"));
        Thread.sleep(1000);
    }

    // attachment selection from folder location
    public static String loadAttachment(String file) {
        URL fileUrl = ClassLoader.getSystemResource(folder + file);
        try {
            file = new File(fileUrl.toURI()).getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }
}
