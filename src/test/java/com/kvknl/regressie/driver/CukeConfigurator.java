package com.kvknl.regressie.driver;

import com.kvknl.regressie.definitions.generic.BasePage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CukeConfigurator {
    public CukeConfigurator() {
        setProp();
    }

    private static RemoteWebDriver driver;
    private String Proxy = "proxy1.kvk.nl:8080";

    @Value("${browser.name.local}")
    private String localBrowserName;

    @Value("${browser.name.remote}")
    private String remoteBrowserName;

    @Value("${remote.url.address}")
    private String remoteUrl;

    @Value("${chrome.driver.version}")
    private String chromeDriverVersion;

    @Value("${firefox.driver.version}")
    private String firefoxDriverVersion;

    @Value("${implicit.wait.timeout.seconds}")
    protected int impWaitTimeout;

    @Value("${browser.screen.size}")
    private String browserScreenSize;
    /**
     * screenshot value links to class/method:
     * {@link com.kvknl.regressie.driver.TestHooks#embedScreenshot}
     */
    @Value("${webdriver.screenshots:false}")
    protected boolean screenshots;

    /**
     * below values link to class:
     * {@link BasePage}
     */
    @Setter
    protected int timeOutInterval;
    protected String dev_login;
    protected String dev_password;
    public String targetHostName;
    protected String testdata_dir;


    @Bean
    @Profile("default")
    // default spring profile for chrome and firefox
    public WebDriver getLocalDriver() {

        if (localBrowserName.contains("chrome")) {
            if (chromeDriverVersion.equals("latest")) {
                ChromeDriverManager.getInstance().proxy(Proxy).setup();
            } else {
                ChromeDriverManager.getInstance().version(chromeDriverVersion).proxy(Proxy).setup();
            }
            final ChromeOptions options = new ChromeOptions();
            if (localBrowserName.toLowerCase().contains("headless")) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
            } else {
                options.addArguments("--start-fullscreen");
            }
            return new EventFiringWebDriver(new org.openqa.selenium.chrome.ChromeDriver(options));
        }
        if ("firefox".equalsIgnoreCase(localBrowserName)) {

            if (firefoxDriverVersion.equals("latest")) {
                FirefoxDriverManager.getInstance().proxy(Proxy).setup();

            } else {
                FirefoxDriverManager.getInstance().version(firefoxDriverVersion).proxy(Proxy).setup();
            }
            ProfilesIni profile = new ProfilesIni();
            final FirefoxProfile firefoxProfile = profile.getProfile("CucumberFirefoxProfiel");
            return new EventFiringWebDriver(new FirefoxDriver(firefoxProfile));
        }
        throw new IllegalArgumentException(String.format("Illegal value for browser parameter: %s", localBrowserName));
    }


    @Bean
    @Profile("remote")
    // remote spring profile. runs via selenium grid
    public WebDriver getRemoteDriver() throws MalformedURLException {

        // set kvk.nl proxy server
        //org.openqa.selenium.Proxy proxy = new Proxy().setHttpProxy(Proxy).setFtpProxy(Proxy).setSslProxy(Proxy)
                //.setSocksProxy(Proxy);
        DesiredCapabilities capabilities = null;
        if (remoteBrowserName.toLowerCase().contains("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setCapability("recordVideo", false);
            capabilities.setCapability("idleTimeout", 60);
            if (browserScreenSize.toLowerCase().equals("default")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-fullscreen");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            } else {
                capabilities.setCapability("screenResolution", browserScreenSize);
            }
            //capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
        if (remoteBrowserName.toLowerCase().contains("firefox")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("firefox");
            capabilities.setCapability("recordVideo", false);
            capabilities.setCapability("idleTimeout", 60);
            //capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
        // request node to the hub
        driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

        // puts an Implicit wait, Will wait for 10 seconds before throwing an exception
        driver.manage().timeouts().implicitlyWait(impWaitTimeout, TimeUnit.SECONDS);

        return new EventFiringWebDriver(driver);
    }

    private void setProp() {
        Properties propDefault = new Properties();
        Properties propLocal = new Properties();
        InputStream inputDefault = null;
        InputStream inputLocal = null;
        try {
            inputDefault = new FileInputStream("src/test/resources/spring-properties/config-default.properties.yml");
            propDefault.load(inputDefault);
            dev_login = propDefault.getProperty("dev.zoeken");
            dev_password = propDefault.getProperty("dev.password");
            targetHostName = propDefault.getProperty("target.host.name");
            timeOutInterval = Integer.parseInt(propDefault.getProperty("timeout.interval.seconds"));
            testdata_dir = propDefault.getProperty("test.data.dir");
            Path path = Paths.get("src/test/resources/spring-properties/local.properties.yml");
            if (!Files.exists(path)) {
                propDefault.load(inputDefault);
                targetHostName = propDefault.getProperty("target.host.name");
            } else {
                inputLocal = new FileInputStream("src/test/resources/spring-properties/local.properties.yml");
                propLocal.load(inputLocal);
                targetHostName = propLocal.getProperty("target.host.name");
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (inputLocal != null) {
                try {
                    inputLocal.close();
                    inputDefault.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
