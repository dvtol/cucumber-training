package com.ahold.ecommerce.driver;

import com.ahold.ecommerce.definitions._generics.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.logging.Level;

@Slf4j
public class TestHooks extends CukeConfigurator {

    private final EventFiringWebDriver webDriver;
    private final BasePage basePage;


    public TestHooks(EventFiringWebDriver webDriver, BasePage basePage) {
        this.webDriver = webDriver;
        this.basePage = basePage;
    }

    @Before
    public void initCookies() {

        // delete cookies and refresh before each test starts
        basePage.deleteAllCookies();
        basePage.refreshPage();
    }

    @After
    public void addLogEntryOnFailure(final Scenario scenario) {
        if (scenario.isFailed()) {
            embedScreenshot(scenario);
            log.info("** Test gefaald, probeer browser logs op te halen - helaas levert dat meestal geen informatie");
            final LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);

            for (final LogEntry logEntry : logEntries.getAll()) {
                if (logEntry.getLevel().intValue() > Level.WARNING.intValue()) {
                    log.error("** Console log entry: [{}] {}", logEntry.getLevel().getName(), logEntry.getMessage());
                }
            }
            failedSnapshot();
        }
    }

    @Attachment
    public String attachmentOfTheLog(String actionSequence) {
        return actionSequence.toString();
    }

    @After
    public void embedScreenshot(final Scenario scenario) {
        if (screenshots) {
            log.info("creating screenshot");
            scenario.write("\n" + "[ Current Page URL: " + webDriver.getCurrentUrl() + " ]");
            scenario.write("\n" + "[ Current Page Title: " + webDriver.getTitle() + " ]");
            try {
                final byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (final WebDriverException somePlatformsDontSupportScreenshots) {
                somePlatformsDontSupportScreenshots.printStackTrace();
                log.error(somePlatformsDontSupportScreenshots.getMessage(), somePlatformsDontSupportScreenshots);
            } finally {
                log.info("creating screenshot done");
            }
        }
    }

    @Attachment(value = "Snapshot of failed test", type = "image/png")
    public byte[] failedSnapshot() {
        final byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}