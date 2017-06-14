package com.ahold.ecommerce.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebDriverConfiguration {

    private static final String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    private static RemoteWebDriver driver;
    private String Proxy = "http://newproxypac.ah.nl:8000";

    @Value("${webdriver.binary.path}")
    private File webDriverPath;

    @Value("${webdriver.binary.executable}")
    private String webDriverExecutable;

    @Value("${browser.name.local}")
    private String localBrowserName;

    @Value("${browser.name.remote}")
    private String remoteBrowserName;

    @Value("${remote.url.address}")
    private String remoteUrl;

    @Value("${implicit.wait.timeout.seconds}")
    int impWaitTimeout;

    @Bean
    @Profile("wdm")
    // spring profile for webdriver manager for chrome and firefox
    public WebDriver getDriver() {
        if ("chrome".equalsIgnoreCase(localBrowserName)) {
            ChromeDriverManager.getInstance().proxy(Proxy).setup();
            final ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-fullscreen");
            return new EventFiringWebDriver(new org.openqa.selenium.chrome.ChromeDriver(options));
        }
        if ("firefox".equalsIgnoreCase(localBrowserName)) {
            FirefoxDriverManager.getInstance().proxy(Proxy).setup();
            final FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("network.proxy.type", 0);
            firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
            return new EventFiringWebDriver(new FirefoxDriver(firefoxProfile));
        }

        throw new IllegalArgumentException(String.format("Illegal value for browser parameter: %s", localBrowserName));
    }

    @Bean
    @Profile("chrome-local")
    // spring profile for running test local with chrome
    public WebDriver chromeDriver() {
        final File pathToBinary = getExecutableFile();
        System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, pathToBinary.getAbsolutePath());

        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");

        return new EventFiringWebDriver(new org.openqa.selenium.chrome.ChromeDriver(options));
    }

    @Bean
    @Profile("default")
    // default spring profile. profile runs auto if no parameter is selecteda
    public WebDriver remoteDriver() throws MalformedURLException {

        // set ah proxy
        org.openqa.selenium.Proxy proxy = new Proxy().setHttpProxy(Proxy).setFtpProxy(Proxy).setSslProxy(Proxy)
                .setSocksProxy(Proxy);
        DesiredCapabilities capabilities = null;
        if (remoteBrowserName.toLowerCase().contains("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
        if (remoteBrowserName.toLowerCase().contains("firefox")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("firefox");
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
        // request node to the hub
        driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

        // puts an Implicit wait, Will wait for 10 seconds before throwing an exception
        driver.manage().timeouts().implicitlyWait(impWaitTimeout, TimeUnit.SECONDS);

        return new EventFiringWebDriver(driver);
    }

    private File getExecutableFile() {
        // selects OS executable based on os-name and arch-type
        String extension;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
            extension = ".exe";
        } else if (osName.contains("mac os x")) {
            extension = "";
        } else if (osName.contains("linux")) {
            extension = ".linux64";
        } else {
            throw new UnsupportedOperationException("Platform " + osName);
        }

        return new File(this.webDriverPath, webDriverExecutable + extension);
    }
}
