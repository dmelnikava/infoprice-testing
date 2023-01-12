package com.solvd.infopricetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    private WebDriver driver;
    private HomePage homePage;

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/solvd/Documents/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://infoprice.by/");
        AbstractPage.setDriver(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}