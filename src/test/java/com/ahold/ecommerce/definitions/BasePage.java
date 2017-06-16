package com.ahold.ecommerce.definitions;

import com.google.common.base.Function;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class BasePage extends BasePageAH{
    private WebDriver webDriver;

    private static final long SECONDS_PAGELOAD_TIMEOUT = 12;

    public BasePage(final WebDriver webdriver) {
        super(webdriver);
        this.webDriver = webdriver;
    }

    /* WebDriver */
    protected void turnOnImplicitWaits(final int time, final TimeUnit timeUnit) {
        webDriver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    protected void turnOffImplicitWaits() {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    private WebDriverWait getWebDriverWait(final long numberOfSeconds) {
        return new WebDriverWait(webDriver, numberOfSeconds);
    }

    private WebDriverWait getWebDriverWait() {
        return getWebDriverWait(timeOutInterval);
    }

    public WebElement findElement(final By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(final By locator) {
        return webDriver.findElements(locator);
    }

    public boolean containsInPageSource(final String value) {
        return webDriver.getPageSource().contains(value);
    }

    public void waitForPageToLoad(final By waitForElement) {
        waitForPageToLoad(SECONDS_PAGELOAD_TIMEOUT, waitForElement);
    }

    public void waitForPageToLoad(final long numberOfSeconds, final By locator) {
        final WebDriverWait wait = new WebDriverWait(webDriver, numberOfSeconds);
        wait.withMessage("Element [" + locator.toString() + "] is not currently visible and so may not be interacted with");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    public void navigateBack() {
        webDriver.navigate().back();
    }

    public void quitWebDriver() {
        webDriver.quit();
    }

    public void closeWebDriver() {
        webDriver.close();
    }

    /**
     * Navigate to the appie today home page of the given environment
     * @param environment    subdomain of the environment, eg 'tst', 'beta'
     */
    public void navigateToEnvironment(final String environment) {
        navigateToEnvironment(environment, "/");
    }

    /**
     *
     * Navigate to the given appie today page of an environment
     * @param environment    subdomain of the environment, eg 'tst', 'beta'
     * @param path           path to navigate to, should start with a '/'
     */
    public void navigateToEnvironment(final String environment, final String path) {
        navigateToPage("http://" + environment + ".appietoday.nl" + path);
    }

    public void navigateForward() {
        webDriver.navigate().forward();
    }

    public void navigateToPage(final String url) {
        webDriver.navigate().to(url);
    }

    public void navigateToPage(final URL url) {
        webDriver.navigate().to(url);
    }

    public String elementGetAttributeHref(final By locator) {
        return getAttributeOfElement(locator, "href");
    }

    public Set<Cookie> getCookies() {
        return webDriver.manage().getCookies();
    }

    public void deleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }

    public void addCookie(final String name, final String value) {
        webDriver.manage().addCookie(new Cookie(name, value));
    }

    public void isCookieNoticeVisible() {
        assertButtonVisibleAndEnabled("accept-cookies");
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public Object executeJavaScript(final String script) {
        return ((JavascriptExecutor) webDriver).executeScript(script);
    }

    public String getAttributeOfElement(final By locator, final String attr) {
        return findElement(locator).getAttribute(attr);
    }

    /* elementen  */
    public void waitForElementPresent(final By locator, final long numberOfSeconds) {
        final WebDriverWait wait = getWebDriverWait(numberOfSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementPresent(final By locator) {
        waitForElementPresent(locator, timeOutInterval);
    }

    public void waitForElementVisible(final By locator, final long numberOfSeconds) {
        final WebDriverWait wait = getWebDriverWait(numberOfSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementVisible(final By locator) {
        waitForElementVisible(locator, timeOutInterval);
    }

    public void sendKey(final By locator, final Keys key) {
        findElement(locator).sendKeys(key);
    }

    public void sendTab(final By locator) {
        sendKey(locator, Keys.TAB);
    }

    /* inputElementen  */
    public boolean inputElementIsEnabled(final By locator) {
        return findElement(locator).isEnabled();
    }

    public void assertInputElementIsEnabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(isEnabledOfElementLocated(locator, true));
    }

    public void assertInputElementIsDisabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(isEnabledOfElementLocated(locator, false));
    }

    /**
     * Click the button given by the locator
     * Note: alleen voor form fields
     * @param locator    the locator defining which button to click
     */
    public void buttonClick(final By locator) {
        waitForElementVisible(locator);
        findElement(locator).click();
    }

    /**
     * Click the button that has the given data-test attribute
     * Note: alleen voor form fields
     * @param dataTest   the value of the data-test attribute
     */
    public void buttonClick(final String dataTest) {
        final By locator = byTestHook(dataTest);
        waitForElementVisible(locator);
        findElement(locator).click();
    }

    public void assertButtonVisibleAndEnabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(isEnabledOfElementLocated(locator, true));
    }

    public void assertButtonVisibleAndEnabled(final String dataTest) {
        final WebDriverWait wait = getWebDriverWait();
        By locator = byTestHook(dataTest);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(isEnabledOfElementLocated(locator, true));
    }

    public void assertButtonVisibleAndDisabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(isEnabledOfElementLocated(locator, false));
    }

    public void assertButtonVisible(final By locator) {
        waitForElementVisible(locator);
    }


    public void assertPath(final Matcher<String> matcher) {

        shortFluentWait(element -> matchString(matcher, getCurrentPath()));
    }

    public void returnButtonIsClickable(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /* checkbox */
    public void checkBoxVisibleAndCheck(final By locator) {
        waitForElementVisible(locator);
        final WebElement element = findElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkBoxVisibleAndUncheck(final By locator) {
        waitForElementVisible(locator);
        final WebElement element = findElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void assertElementVisibleAndCheck(final By locator) {
        waitForElementVisible(locator);
        Assert.assertEquals(findElement(locator).isSelected(), true);
    }

    public void assertElementVisibleAndUncheck(final By locator) {
        waitForElementVisible(locator);
        Assert.assertEquals(findElement(locator).isSelected(), true);
    }

    public boolean checkboxIsSelected(final By locator) {
        return findElement(locator).isSelected();
    }

    /* radiobuttons*/
    public void radioButtonVisibleAndSelect(final By locator) {
        waitForElementVisible(locator);
        findElement(locator).click();
    }

    public void radioButtonVisibleAndSelectByIndex(final By locator, final int option) {
        waitForElementVisible(locator);
        final List<WebElement> radios = findElements(locator);
        if (option > 0 && option <= radios.size()) {
            radios.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found (counting as 1,2,3,...)");
        }
    }

    public void assertRadioButtonVisibleAndSelected(final By locator) {
        waitForElementVisible(locator);
        Assert.assertEquals(findElement(locator).isSelected(), true);
    }

    public void assertRadioButtonVisibleAndNotSelected(final By locator) {
        waitForElementVisible(locator);
        Assert.assertEquals(findElement(locator).isSelected(), false);
    }

    public boolean radioButtonIsSelected(final By locator) {
        waitForElementVisible(locator);
        return findElement(locator).isSelected();
    }

    /* dropdown (select) */
    public String dropdownGetTextFirstSelected(final By locator) {
        waitForElementVisible(locator);
        WebElement selectedOption = new Select(findElement(locator)).getFirstSelectedOption();
        return selectedOption.getText();
    }

    public List<String> dropdownGetTextAllSelected(final By locator) {
        waitForElementVisible(locator);
        final List<WebElement> selectedOptions = new Select(findElement(locator)).getAllSelectedOptions();
        final List<String> selectedOptionsText = new ArrayList<String>();
        for (WebElement element : selectedOptions) {
            selectedOptionsText.add(element.getText());
        }
        return selectedOptionsText;
    }

    public void dropdownSelectByValue(final By locator, final String... listOfValues) {
        waitForElementVisible(locator);
        if (listOfValues != null && listOfValues.length > 0) {
            final Select select = new Select(findElement(locator));
            if (select.isMultiple()) {
                select.deselectAll();
                for (String value : listOfValues) {
                    select.selectByValue(value);
                }
            } else {
                select.selectByValue(listOfValues[0]);
            }
        } else {
            throw new IllegalArgumentException("at least one value is required to select");
        }
    }

    public void dropdownSelectByText(final By locator, final String... listOfTextValues) {
        waitForElementVisible(locator);
        if (listOfTextValues != null && listOfTextValues.length > 0) {
            final Select select = new Select(findElement(locator));
            if (select.isMultiple()) {
                select.deselectAll();
                for (String text : listOfTextValues) {
                    select.selectByVisibleText(text);
                }
            } else {
                select.selectByVisibleText(listOfTextValues[0]);
            }
        } else {
            throw new IllegalArgumentException("at least one text value is required to select");
        }
    }

    public void dropdownSelectByIndex(final By locator, final int... listOfIndexValues) {
        waitForElementVisible(locator);
        if (listOfIndexValues != null && listOfIndexValues.length > 0) {
            final Select select = new Select(findElement(locator));
            if (select.isMultiple()) {
                select.deselectAll();
                for (int index : listOfIndexValues) {
                    select.selectByIndex(index);
                }
            } else {
                select.selectByIndex(listOfIndexValues[0]);
            }
        } else {
            throw new IllegalArgumentException("at least one index value is required to select");
        }
    }

    public void assertDropdownSelectedContainsText(final By locator, final String value) {
        waitForElementVisible(locator);
        final Select select = new Select(findElement(locator));
        final List<WebElement> selectedOptions = select.getAllSelectedOptions();
        boolean hasFoundValue = false;
        for (WebElement option : selectedOptions) {
            if (option.getText().equals(value)) {
                hasFoundValue = true;
            }
        }
        Assert.assertTrue("Could not find " + value + " in the dropdown menu", hasFoundValue);
    }

    /* DOM */
    public void assertDOMContainsInnerText(final By locator, final String value) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
    }

    public void assertDOMContainsInnerNumber(final By locator, final String value) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
    }

    public void assertDOMContainsAnyInnerText(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(anyTextToBePresentInElementLocated(locator));
    }

    /* field-type Date */
    public void inputDateSetDate(final By locator, final int year, final int month, final int day) {
        waitForElementVisible(locator);

        final WebElement element = findElement(locator);
        element.sendKeys(month + "/" + day + "/" + year);
    }

    public void inputSetEmail(final By locator, final String email) {
        waitForElementVisible(locator);

        final WebElement element = findElement(locator);
        element.sendKeys(email);
    }

    public void inputDateSetDate(final By locator, final String value) {
        waitForElementVisible(locator);

        try {
            final DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            final DateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
            final Date inputDate = inputFormat.parse(value);

            final WebElement element = findElement(locator);
            element.sendKeys(outputFormat.format(inputDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void inputDateSetValueByName(final String name, final Date value) {
        final By locator = By.name(name);
        waitForElementVisible(locator);

        final DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final String formattedDate = format.format(value);

        final WebElement element = findElement(locator);
        element.sendKeys(formattedDate);
    }

    public String inputDateGetValue(final By locator) {
        waitForElementVisible(locator);
        return findElement(locator).getAttribute("value");
    }

    /* field-type Number */
    public void inputNumberSetNumber(final By locator, final String value) {
        assertStringIsNumeric(value);
        waitForElementVisible(locator);
        textInputSetText(locator, value);
    }

    public String inputNumberGetText(final By locator) {
        waitForElementVisible(locator);
        return findElement(locator).getAttribute("value");
    }

    /* TextInput */
    public void textInputSetText(final By locator, final String value) {
        waitForElementVisible(locator);
        final WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void textInputAppendText(final By locator, final String value) {
        waitForElementVisible(locator);
        findElement(locator).sendKeys(value);
    }

    public String textInputGetText(final By locator) {
        waitForElementVisible(locator);
        return findElement(locator).getText();
    }

    public String textInputGetValue(final By locator) {
        waitForElementVisible(locator);
        return getAttributeOfElement(locator, "value");
    }

    public boolean textInputIsEnabled(final By locator) {
        waitForElementVisible(locator);
        return findElement(locator).isEnabled();
    }

    public void assertTextInputIsEnabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(isEnabledOfElementLocated(locator, true));
    }

    public void assertTextInputIsDisabled(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(isEnabledOfElementLocated(locator, false));
    }

    public void assertTextInputContainsText(final By locator, final String text) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void assertTextInputContainsAnyText(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(anyTextToBePresentInElementLocated(locator));
    }

    public void assertTextInputContainsValue(final By locator, final String text) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }

    public void assertTextInputContainsAnyValue(final By locator) {
        final WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(anyTextToBePresentInElementValue(locator));
    }



    // used for debugging purposes only
    @Deprecated
    public void pause(final long timeInMillies) {
        try {
            Thread.sleep(timeInMillies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* custom expected conditions */
    private static ExpectedCondition<Boolean> isEnabledOfElementLocated(final By locator, final boolean isEnabled) {
        return new ExpectedCondition<Boolean>() {
            private boolean elementIsEnabled;

            public Boolean apply(final WebDriver driver) {
                elementIsEnabled = driver.findElement(locator).isEnabled();
                return isEnabled == elementIsEnabled;
            }

            public String toString() {
                return String.format("Expected element to be enabled \"%s\". Element enabled is: \"%s\"", isEnabled, elementIsEnabled);
            }
        };
    }

    private static ExpectedCondition<Boolean> anyTextToBePresentInElementLocated(final By locator) {
        return new ExpectedCondition<Boolean>() {
            private String text;
            public Boolean apply(final WebDriver driver) {
                text = driver.findElement(locator).getText();
                return !text.isEmpty();
            }

            public String toString() {
                return String.format("Element contains text \'%s\'", text);
            }
        };
    }

    public static ExpectedCondition<Boolean> anyTextToBePresentInElementValue(final By locator) {
        return new ExpectedCondition<Boolean>() {
            private String text;
            public Boolean apply(final WebDriver driver) {
                try {
                    text = driver.findElement(locator).getAttribute("value");
                    return text != null?Boolean.valueOf(!text.isEmpty()):Boolean.valueOf(false);
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }

            public String toString() {
                return String.format("text (\'%s\') to be the value of element located by %s", text, locator);
            }
        };
    }


    /**
     * A selector by the value of the data-test attribute
     * @param dataTest
     * @return
     */
    private By byTestHook(String dataTest) {
        return  By.xpath(String.format("//*[@data-test=\"%s\"]", dataTest));
    }

    // custom assertions
    private void assertStringIsNumeric(final String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            Assert.fail("value should be numeric");
        }
    }

    private void shortFluentWait(final Function<WebDriver, Boolean> function) {
        new FluentWait<>(webDriver).withTimeout(SECONDS_PAGELOAD_TIMEOUT, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
                .until(function);
    }

    private Boolean matchString(final Matcher<String> matcher, final String string) {
        if (matcher.matches(string)) {
            return true;
        }
        return false;
    }

    private String getCurrentPath() {
        try {
            return new URL(getCurrentUrl()).getPath();
        } catch (final MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
