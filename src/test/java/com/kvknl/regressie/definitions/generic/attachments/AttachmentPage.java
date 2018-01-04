package com.kvknl.regressie.definitions.generic.attachments;

import com.codeborne.selenide.WebDriverRunner;
import com.kvknl.regressie.data._JsonData;
import com.kvknl.regressie.definitions.generic.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class AttachmentPage extends BasePage {

    private static final String folder = "bijlagen/";

    public AttachmentPage(WebDriver webDriver) {
        super(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

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
