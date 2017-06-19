package com.ahold.ecommerce.definitions;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.or;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@SuppressWarnings("unused")
@Component
public class BasePageAH {

    private static final int WAIT_REFRESH = 5;

    @Value("${timeout.interval.seconds}")
    protected int timeOutInterval;

    @Value("${dev.login}")
    protected String dev_login;

    @Value("${dev.password}")
    protected String dev_password;

    @Value("${target.host.name:tst8.ah.nl}")
    protected String targetHostName;

    protected final WebDriver driver;

    public BasePageAH(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().setSize(new Dimension(1300, 1024));
    }

    public static By css(final String format, final Object... args) {
        return By.cssSelector(format(format, args));
    }

    public static By id(final String format, final Object... args) {
        return By.id(format(format, args));
    }

    public static By appieValue(final String value) {
        return css("[data-appie='%s']", value);
    }

    public static By name(final String value) {
        return css("[name='%s']", value);
    }

    public static By dataterm(final String value) {
        return css("[data-term='%s']", value);
    }

    public BasePageAH switchTo(WebElement webElement) {
        WebDriver frame = driver.switchTo().frame(webElement);
        BasePageAH switchedDriver = new BasePageAH(frame);
        switchedDriver.setTimeOutInterval(timeOutInterval);
        return switchedDriver;
    }


    /**
     * Retrieve a test hook {@link By locator}. A Test hook on a web element is HTML element attribute with the name
     * <pre>data-testhookid</pre> The test hook by can be retrieved with optional arguments which are used as in {@link By#cssSelector(String)}
     *
     * @param format the test-hook identifier.
     * @param args   additional arguments for the test-hook identifier.
     * @return the resolved test-hook locator.
     */
    public static By testHook(final String format, final Object... args) {
        return css("[data-testhookid='%s']", format(format, args));
    }

    public static By testHookStartsWith(String format, final Object... args) {
        return css("[data-testhookid^='%s']", format(format, args));
    }

    public static By testHookStartsWithWithinCss(String css, String testHookId) {
        return css("%s [data-testhookid^='%s']", css, testHookId);
    }

    //Used to find another element in the hierarchy of the element of the specified testhook
    public static By cssWithinTestHook(String testHookId, String css) {
        return css("[data-testhookid='%s'] %s", testHookId, css);
    }

    //Used to find elements with the specified testhook plus the extraCSS
    public static By cssCombinedWithTestHook(String testHookId, String extraCSS) {
        return css("[data-testhookid='%s']%s", testHookId, extraCSS);
    }

    public void goBack() {
        driver.navigate().back();
    }

    private WebDriverWait pauseQuickly() {
        return new WebDriverWait(driver, WAIT_REFRESH);
    }

    public void deleteAllSessionCookies() {
        for (final Cookie cookie : driver.manage().getCookies()) {
            // remove all but cookies-accepted
            if (!cookie.getName().equals("cookies-accepted")) {
                driver.manage().deleteCookie(cookie);
            }
        }
    }

    public void deleteJSessionIdCookie() {
        driver.manage().deleteCookieNamed("JSESSIONID");
    }

    public void setDimension(Dimension dimension) {
        driver.manage().window().setSize(dimension);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void shutdown() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public void setup() {
        closeTabs();
        deleteAllCookies();
        acceptCookies();
    }

    private void closeTabs() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i)).close();
        }
        driver.switchTo().window(tabs.get(0));
    }

    private void acceptCookies() {
        // need page before cookies can be set
        openPath("/privacy");
        // version number/cookie value hard coded. Might change in future.
        final Cookie cookie = new Cookie("cookies-accepted", "1.3");
        driver.manage().addCookie(cookie);
        log.info("Cookie set: " + cookie.getName());
    }

    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

    public boolean onHomePage() {
        return getUrl().equals(format("https://%s", targetHostName));
    }

    public void openHomePage() {
        get(format("https://%s", targetHostName));
        assertValidPage();
    }

    /**
     * Officially the 'path' component of a url does not contain the first slash ("/"), but seeing that for testing purposes it's easier to
     * pass an absolute url with a "/" that's what's expected for the format parameter
     *
     * @param format url starting with "/"
     * @param args   additional arguments.
     */
    public void openPath(final String format, final Object... args) {
        get(format("https://%s%s", targetHostName, format(format, args)));
        assertValidPage();
    }

    /**
     * Same as openPath but with Basic authentication for the specified path
     *
     * @param path url starting with "/"
     * @param args additional arguments.
     */
    public void openPathWithLoginForDev(final String path, final Object... args) {
        get(format("https://%s:%s@%s%s", dev_login, dev_password, targetHostName, format(path, args)));
        assertValidPage();
    }

    /**
     * Open a site target page
     *
     * @param siteTarget The site target to navigate to
     * @param args       Arguments to insert into the URL string
     */
    public void openPageBySiteTarget(final String siteTarget, final Object... args) {
        openPath("/grid/sitetarget/" + siteTarget, args);
    }

    public boolean isUrl(final String subUrl) {
        final String url = getUrl();
        return url.contains(targetHostName + subUrl);
    }

    public boolean isNetherlands() {
        return targetHostName.contains("ah.nl");
    }

    public boolean hasElement(final By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (TimeoutException | NoSuchElementException te) {
            return false;
        }
    }

    public Cookie getCookie(String cookieName) {
        return driver.manage().getCookieNamed(cookieName);
    }

    public void input(final By by, final String value) {
        expectShortly(presenceOfElementLocated(by)).sendKeys(value);
    }

    /**
     * Enter input into a {@link By} and send the given keys.
     * This method will first call {@link #visible(By)} click on the input field, clear it, send the keys.
     *
     * @param by    the locator.
     * @param value the string to be send to the element.
     * @param keys  additional keys like {@link Keys#ENTER} to send to the element.
     */
    public void inputVisible(final By by, final String value, final Keys... keys) {
        retryOnElementNotClickable(() -> visible(by, element -> this.inputVisible(element, value, keys)));
    }

    public void inputVisible(final WebElement element, final String value, final Keys... keys) {
        element.click();
        element.clear();
        element.sendKeys(value);
        Arrays.asList(keys).forEach(element::sendKeys);
    }

    public BasePageAH switchToDefault() {
        WebDriver frame = driver.switchTo().defaultContent();
        return new BasePageAH(frame);
    }

    /**
     * Higher order method, consumes the given consumer, for a given locator.
     *
     * @param by       the locator.
     * @param consumer the consumer.
     */
    public void visible(final By by, final Consumer<WebElement> consumer) {
        consumer.accept(visible(by));
    }

    /**
     * Retrieve a {@link WebElement} or <code>null</code> which will wait for an AJAX call to complete and then for 10 seconds.
     *
     * @param by the locator.
     * @return the web element.
     */
    public WebElement visible(final By by) {
        return expectShortly(visibilityOfElementLocated(by));
    }

    private <V> V expectShortly(final ExpectedCondition<V> webElementExpectedCondition) {
        return new WebDriverWait(driver, timeOutInterval).until(webElementExpectedCondition);
    }

    public void clickVisible(final By by) {
        retryOnElementNotClickable(() -> visible(by).click());
    }

    public void clickEitherVisible(By option1, By option2) {
        if (presentAndVisible(option1)) {
            clickVisible(option1);
        } else if (presentAndVisible(option2)) {
            clickVisible(option2);
        } else {
            throw new ElementNotVisibleException("couldn't find a visible element with by either of these 2 options: " + option1 + " / " + option2);
        }
    }

    private void retryOnElementNotClickable(Runnable runnable) {
        try {
            runnable.run();
        } catch (WebDriverException e) {
            if (e.getMessage().contains("Element is not clickable at point")) {
                // some sort of animation is moving things around, just try again after a short delay
                log.info(e.getMessage());
                sleep(Duration.ofSeconds(1));
                runnable.run();
            } else {
                throw e;
            }
        }
    }

    public WebElement presence(final By by) {
        return expectShortly(presenceOfElementLocated(by));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public URL getURL() {
        try {
            return new URL(getUrl());
        } catch (final MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void retry(final Predicate<Void> predicate) {
        for (int i = 0; i < 2; i++) {
            try {
                if (predicate.apply(null)) {
                    return;
                }
                log.warn("Retrying...");
            } catch (final TimeoutException e) {
                log.warn("Retrying... {}", e.getMessage());
                if (i == 1) {
                    throw e;
                }
            }
        }
    }

    public void content(final By by, final String text) {
        assertTrue(text, expectShortly(textToBePresentInElementLocated(by, text)));
    }

    public void refreshWhilePresent(final By by) {
        for (int i = 0; i < 5; i++) {
            try {
                pauseQuickly().until(visibilityOfElementLocated(by));
                driver.navigate().refresh();
            } catch (NoSuchElementException | TimeoutException e) {
                return;
            }
        }
        fail(format("%s still present", by.toString()));
    }

    public void refreshWhileNotPresent(final By by) {
        for (int i = 0; i < 10; i++) {
            try {
                driver.navigate().refresh();
                if (presentAndVisible(by)) {
                    return;
                } else {
                    Thread.sleep(1000);
                }
            } catch (NoSuchElementException | TimeoutException e) {
                break;
            } catch (InterruptedException ignored) {
            }
        }
        fail(format("%s still not present", by.toString()));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public List<WebElement> elements(final By by) {
        return expectShortly(presenceOfAllElementsLocatedBy(by));
    }

    public WebElement element(final By by) {
        final List<WebElement> es = elements(by);
        return es.get(0);
    }

    public WebElement last(final By by) {
        final List<WebElement> es = elements(by);
        return es.get(es.size() - 1);
    }

    public WebElement extractCheckBox(final By by) {
        if (presentOneElement(by)) {
            final WebElement element = last(by);
            final WebElement elementWithInput = element.findElement(By.tagName("input"));
            if (elementWithInput != null) {
                final String type = elementWithInput.getAttribute("type");
                if ("checkbox".equals(type)) {
                    return elementWithInput;
                } else {
                    throw new IllegalArgumentException("Input element is not a checkbox: " + by);
                }
            } else {
                throw new IllegalArgumentException("Could not find input element in: " + by);
            }
        }
        throw new IllegalArgumentException("Could not find element macthing: " + by);
    }

    public WebElement extractSelectOption(final By by, final int optionIndexNo) {
        if (presentOneElement(by)) {
            final WebElement element = last(by);
            final List<WebElement> options = element.findElements(By.tagName("option"));
            if (options != null) {
                if (optionIndexNo >= 0 && optionIndexNo < options.size()) {
                    return options.get(optionIndexNo);
                } else {
                    throw new IllegalArgumentException("Invalid optionIndexNo for select: " + by);
                }
            } else {
                throw new IllegalArgumentException("Input element is not a select: " + by);
            }
        }
        throw new IllegalArgumentException("Could not find element macthing: " + by);
    }

    public boolean presentOneElement(final By by) {
        return driver.findElements(by).size() == 1;
    }

    public boolean presentOneOrMoreElements(final By by) {
        return driver.findElements(by).size() >= 1;
    }

    public int noOfElements(final By by) {
        return driver.findElements(by).size();
    }

    public boolean presentAndVisible(final By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements.size() >= 1 && elements.get(0).isDisplayed();
    }

    public void sleep(final Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean pollPresentAndVisible(final By by) {
        return pollVisible(by) != null;
    }

    public WebElement pollVisible(final By by) {
        return pollShortly().until(visibilityOfElementLocated(by));
    }

    public void pollClickVisible(final By by) {
        WebElement elementToClick = pollVisible(by);
        for (int i = 0; i <= 2; i++) {
            try {
                elementToClick.click();
                break;
            } catch (StaleElementReferenceException e) {
                log.warn(i + "e poging faalde");
                if (i == 2) {
                    throw new StaleElementReferenceException("selectie van element om op te klikken ging niet goed");
                }
                sleep(Duration.ofMillis(500));
            } catch (WebDriverException e) {
                log.warn("Klikken ging mis", e);
                if (i == 2) {
                    throw new TimeoutException("Element gevonden, maar klikken ging mis");
                }
                sleep(Duration.ofMillis(500));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void pollClickFirstVisible(final By by) {
        pollShortly().until(presenceOfAllElementsLocatedBy(by)).stream().filter(WebElement::isDisplayed).findFirst().get().click();
    }

    private Wait<WebDriver> pollShortly() {
        return new FluentWait<>(driver).withTimeout(timeOutInterval, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
    }

    private Wait<WebDriver> pollVeryShortly() {
        return new FluentWait<>(driver).withTimeout(timeOutInterval, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class);
    }

    private <T> Wait<T> pollShortly(T t) {
        return new FluentWait<>(t).withTimeout(timeOutInterval, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public byte[] getScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void assertPath(final Matcher<String> matcher) {
        shortFluentWait(element -> matchString(matcher, getURL().getFile()));
    }

    public void assertPath(final String path) {
        pollShortly().until(ExpectedConditions.urlContains(path));
    }

    public static ExpectedCondition<Boolean> urlMatches(final Matcher<String> matcher) {
        return new ExpectedCondition<Boolean>() {
            private String currentUrl = "";

            public Boolean apply(WebDriver driver) {
                this.currentUrl = driver.getCurrentUrl();
                return matcher.matches(currentUrl);
            }

            public String toString() {
                return String.format("Url should match with the matcher. Current url: \"%s\"", this.currentUrl);
            }
        };
    }

    /**
     * Polls shortly until either the element using the given by selector finds a visible element, or
     * the current page's url matches using the given matcher.
     *
     * @param by  element locator
     * @param url url matcher
     * @throws TimeoutException on {@link #pollShortly()} timeout
     */
    public void assertVisibleOrPath(final By by, final Matcher<String> url) {
        pollShortly().until(or(visibilityOfElementLocated(by), urlMatches(url)));
    }

    /**
     * Polls shortly until either the element using the given by selector finds a visible element, or
     * the current page's url matches using the given matcher.
     *
     * @param by   element locator
     * @param url1 url to possibly match
     * @param url2 url to possibly match
     * @throws TimeoutException on {@link #pollShortly()} timeout
     */
    public void assertVisibleOrContainsEitherPath(final By by, final String url1, final String url2) {
        pollShortly().until(or(visibilityOfElementLocated(by), urlContains(url1), urlContains(url2)));
    }

    /**
     * Asserts that the path matches either of the 2 provided paths
     *
     * @param url1 possible path 1
     * @param url2 possible path 2
     */

    public void assertEitherPaths(final String url1, final String url2) {
        pollShortly().until(or(urlContains(url1), urlContains(url2)));
    }

    public void assertTitle(final Matcher<String> matcher) {
        shortFluentWait(element -> matchString(matcher, driver.getTitle()));
    }

    public void assertText(final Matcher<String> matcher, final By by) {
        assertTrue(matchString(matcher, escapeHtml4(presence(by).getText()).replaceAll("&shy;", "")));
    }

    public void assertHeader(Matcher<String> matcher) {
        assertText(matcher, css("header"));
    }

    public void assertVisible(final By by) {
        pollShortly().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement assertVisible(final WebElement webElement, final By by) {
        Wait<WebElement> wait = pollShortly(webElement);
        return wait.until(element -> elementIfVisible(webElement.findElement(by)));
    }

    private WebElement elementIfVisible(WebElement element) {
        return element.isDisplayed() ? element : null;
    }

    public void assertNotVisible(final By by) {
        pollShortly().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void assertVisible(final By by, boolean expectedVisibility) {
        if (expectedVisibility) {
            assertVisible(by);
        } else {
            assertNotVisible(by);
        }
    }

    public void assertVisible(final WebElement webElement, final By by, boolean expectedVisibility) {
        if (expectedVisibility) {
            assertVisible(webElement, by);
        } else {
            assertNotVisible(webElement, by);
        }
    }

    public void assertNotVisible(final WebElement webElement, final By by) {
        Wait<WebElement> wait = pollShortly(webElement);
        wait.until(invisible -> isInvisible(webElement.findElement(by)));
    }

    private boolean isInvisible(final WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        }
    }

    public void assertPresent(final By by) {
        pollShortly().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void assertPresentDynamic(final By by) {
        pollVeryShortly().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void assertNotPresent(final By by) {
        pollShortly().until(ExpectedConditions.not(presenceOfAllElementsLocatedBy(by)));
    }

    public void assertText(final By by, String text) {
        pollShortly().until(textToBePresentInElementLocated(by, text));
    }

    public void assertTextInValue(final By by, String text) {
        pollShortly().until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }

    public void assertValidPage() {
        assertTitle(not(startsWith("500 Internal Server Error")));
        assertTitle(not(startsWith("Storing")));
        if (!getUrl().endsWith("/404")) {
            assertTitle(not(endsWith("niet gevonden")));
        }
    }

    public void assertErrorById(String id, String foutmelding) {
        WebElement error = element(By.id(id));
        Assert.assertThat(error.getText().contains(foutmelding), CoreMatchers.is(true));
    }

    public void assertErrorByXpath(String xpath, String foutmelding) {
        WebElement error = element(By.xpath(xpath));
        Assert.assertThat(error.getText().contains(foutmelding), CoreMatchers.is(true));
    }

    private void shortFluentWait(final Function<WebDriver, Boolean> function) {
        new FluentWait<>(driver).withTimeout(timeOutInterval, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
            .until(function);
    }

    private Boolean matchString(final Matcher<String> matcher, final String string) {
        if (matcher.matches(string)) {
            return true;
        }
        log.info("Waiting for '{}' to match {}", string, matcher);
        return false;
    }

    public boolean canScreenshot() {
        return TakesScreenshot.class.isInstance(driver);
    }

    public String executeScript(final String string, final Object... args) {
        if (JavascriptExecutor.class.isInstance(driver)) {
            return (String) ((JavascriptExecutor) driver).executeScript(format(string, args));
        }
        throw new RuntimeException("Cannot execute JavaScript");
    }

    public void prompt() {
        JOptionPane.showMessageDialog(null, "Confirm to continue...");
    }

    public void scrollTo(By by) {
        new Actions(driver).moveToElement(expectShortly(presenceOfElementLocated(by))).perform();
    }

    public void waitForAjaxCallToFinish() {
        pollVisible(css("html.js-content-ready"));
    }

    public void waitForShoppinglist() {
        try {
            assertPresent(testHook("shoppinglist_quantityshoppinglist"));
            assertPresentDynamic(
                By.xpath("//*[@data-testhookid='shoppinglist_quantityshoppinglist'][contains(@style, 'transform: matrix')]"));
        } catch (final NoSuchElementException | TimeoutException e) {
            log.error("Waiting for the shoppinglist to update took too long", e);
        }
    }

    public void focusSecondTab() {
        focusOnTab(1);
    }

    public void focusOnTab(int tabIndexNo) {
        pollShortly().until(driver -> driver.getWindowHandles().size() > tabIndexNo);
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(tabIndexNo));
    }

    public void openTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    public void closeTab() {
        driver.close();
//        findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }

    /**
     * If the given {@link WebElement element} has focus.
     *
     * @param element the target element.
     */
    public boolean hasFocus(WebElement element) {
        return element.equals(driver.switchTo().activeElement());
    }

    /**
     * Should trigger a javascript .blur event, by sending a TAB key to the active element.
     */
    public void unFocus() {
        unFocus(driver.switchTo().activeElement());
    }

    /**
     * Should trigger a javascript .blur event, by sending a TAB key to the given web element.
     *
     * @param element the target element.
     */
    public void unFocus(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setTimeOutInterval(int timeOutInterval) {
        this.timeOutInterval = timeOutInterval;
    }

}
