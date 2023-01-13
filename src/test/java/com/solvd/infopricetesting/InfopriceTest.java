package com.solvd.infopricetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class InfopriceTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/solvd/Documents/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://infoprice.by/");
        homePage = new HomePage(driver);
    }

    @Test(testName = "Check returning from the Basket page to the Home page")
    public void checkReturnFromBasketPageToHomePageTest() {
        BasketPage basketPage = homePage.clickBasketIcon();
        basketPage.clickOnHomePageButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://infoprice.by/");
    }

    @Test(testName = "Check if the Filter menu locates under Catalog menu")
    public void checkFilterMenuLocationTest() {
        Assert.assertNotNull(homePage.getFilterButtonLocation());
    }

    @Test(testName = "Check the opening of the Filter menu by clicking on the text")
    public void checkOpenFilterMenuTest() {
        homePage.clickFilterButton();
        WebElement filterStatusBar = homePage.getFilterBarShowStatus();

        Assert.assertEquals(filterStatusBar.getAttribute("class"), "collapse show");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}