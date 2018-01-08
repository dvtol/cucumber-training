package com.kvknl.regressie.definitions.googletest;

import com.kvknl.regressie.data._JsonData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.kvknl.regressie.definitions.generic.BasePage;

public class GoogleTestPage extends BasePage {

    _JsonData testdata = new _JsonData();

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

    public void enterTestdataInSearchBox() {
        final WebElement searchBox = findElement(By.name("q"));
        searchBox.sendKeys(testdata.JsonData("kvk_customer_test", "adres"));
        searchBox.submit();
    }

    public void controleerVerwachteWaarde(final String verwachteWaarde) {
        final String result = textInputGetText(By.id("cwos"));
        Assert.assertEquals(verwachteWaarde, result);
    }
}
