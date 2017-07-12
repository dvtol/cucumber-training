package com.ahold.ecommerce.definitions.googletest;

import com.ahold.ecommerce.data._JsonData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ahold.ecommerce.definitions._generics.BasePage;

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
        searchBox.sendKeys(testdata.JsonData("ah_customers", "adres"));
        searchBox.submit();
    }

    public void controleerVerwachteWaarde(final String verwachteWaarde) {
        final String result = textInputGetText(By.id("cwos"));
        Assert.assertEquals(verwachteWaarde, result);
    }
}
