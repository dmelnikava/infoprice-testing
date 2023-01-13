package com.solvd.infopricetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private HomePage homePage;

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/solvd/Documents/selenium/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://infoprice.by/");
        driver.set(webDriver);
        AbstractPage.setDriver(driver.get());
        homePage = new HomePage(driver.get());
    }

    @AfterMethod
    public void tearDown() {
        driver.get().close();
        driver.get().quit();
    }
}