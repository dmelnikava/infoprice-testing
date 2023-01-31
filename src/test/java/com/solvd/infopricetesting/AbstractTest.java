package com.solvd.infopricetesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(AbstractTest.class);
    private String baseUrl = "https://infoprice.by/";;
    private String nodeURL = "http://192.168.88.87:5555/wd/hub";
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private HomePage homePage;

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @Parameters({"browserName"})
    @BeforeMethod()
    public void setUp(String browserName) throws MalformedURLException {
        WebDriver webDriver = null;
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("platformName", "MAC");
                webDriver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", "MAC");
                webDriver = new RemoteWebDriver(new URL(nodeURL), firefoxOptions);
                break;
            default:
                break;
        }
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);
        driver.set(webDriver);
        AbstractPage.setDriver(driver.get());
        homePage = new HomePage(driver.get());
    }

    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        takeScreenshots(result);
        driver.get().close();
    }

    public void takeScreenshots(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver.get();
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("./screenshots/" + result.getName() + ".png"));
            LOGGER.info("Screenshot taken");
        }
    }
}