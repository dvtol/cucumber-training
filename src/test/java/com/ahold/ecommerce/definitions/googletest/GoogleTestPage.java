package com.ahold.ecommerce.definitions.googletest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ahold.ecommerce.definitions.BasePage;

public class GoogleTestPage extends BasePage {

    public GoogleTestPage(final WebDriver webdriver) {
        super(webdriver);
    }

    public void navigateToGoogle() {
        navigateToPage("https://www.google.com/");
    }

    public void enterInSearchBox(final String search) {
        final WebElement searchBox = findElement(By.name("q"));
        searchBox.sendKeys(search);
        searchBox.submit();
    }

    public void controleerVerwachteWaarde(final String verwachteWaarde) {
        final String result = textInputGetText(By.id("cwos"));
        Assert.assertEquals(verwachteWaarde, result);
    }
}
