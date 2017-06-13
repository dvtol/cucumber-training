package com.ahold.ecommerce.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    private static final String FIREFOX_DRIVER_SYSTEM_PROPERTY = "webdriver.gecko.driver";

    private static RemoteWebDriver driver;
    private String Proxy = "http://newproxypac.ah.nl:8000";

    @Value("${webdriver.binary.path}")
    File webDriverPath;

    @Value("${webdriver.binary.executable}")
     String webDriverExecutable;

    @Value("${browser.name.local}")
     String localBrowserName;

    @Value("${browser.name.remote}")
     String remoteBrowserName;

    @Value("${remote.url.address}")
     String remoteUrl;

    @Value("${implicit.wait.timeout.seconds}")
     int impWaitTimeout;

    @Bean
    @Profile("wdm")
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
            return new org.openqa.selenium.firefox.FirefoxDriver(firefoxProfile);
        }

        throw new IllegalArgumentException(String.format("Illegal value for browser parameter: %s", localBrowserName));
    }

    @Bean
    @Profile("chrome-local")
    public WebDriver chromeDriver() {
        final File pathToBinary = getExecutableFile();
        System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, pathToBinary.getAbsolutePath());

        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");

        return new EventFiringWebDriver(
                new org.openqa.selenium.chrome.ChromeDriver(options));
    }

    @Bean
    @Profile("firefox-local")
    public WebDriver firefoxDriver() {

        final File pathToBinary = getExecutableFile();
        System.setProperty(FIREFOX_DRIVER_SYSTEM_PROPERTY, pathToBinary.getAbsolutePath());

        final FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("network.proxy.type", 0);
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);

        return new org.openqa.selenium.firefox.FirefoxDriver(firefoxProfile);
    }

    @Bean
    @Profile("default")
    public WebDriver remoteDriver() throws MalformedURLException {

        // set ah proxy
        org.openqa.selenium.Proxy proxy = new Proxy().setHttpProxy(Proxy).setFtpProxy(Proxy).setSslProxy(Proxy)
                .setSocksProxy(Proxy);

        // request node to the hub
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.LINUX);
        cap.setCapability(CapabilityType.PROXY, proxy);
        driver = new RemoteWebDriver(new URL(remoteUrl), cap);

        // puts an Implicit wait, Will wait for 10 seconds before throwing an exception
        driver.manage().timeouts().implicitlyWait(impWaitTimeout, TimeUnit.SECONDS);

        return new EventFiringWebDriver(driver);
    }

    private File getExecutableFile() {
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
