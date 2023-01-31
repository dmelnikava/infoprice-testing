package com.solvd.infopricetesting;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class InfopriceTest extends AbstractTest {

    @Test(testName = "Check returning from the Basket page to the Home page")
    public void checkReturnFromBasketPageToHomePageTest() {
        BasketPage basketPage = getHomePage().clickBasketIcon();
        basketPage.clickOnHomePage();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://infoprice.by/");
    }

    @Test(testName = "Check if the Filter menu locates under Catalog menu")
    public void checkFilterMenuLocationTest() {
        Assert.assertNotNull(getHomePage().getFilterButtonLocation());
    }

    @Test(testName = "Check the opening of the Filter menu by clicking on the text")
    public void checkOpenFilterMenuTest() {
        getHomePage().clickFilterButton();
        WebElement filterStatusBar = getHomePage().getFilterBarShowStatus();

        Assert.assertEquals(filterStatusBar.getAttribute("class"), "collapse show");
    }

    @Test(testName = "Check if the Close button is present to close the Filter menu")
    public void checkCloseButtonLocationTest() {
        getHomePage().clickFilterButton();
        Point point = getHomePage().getCloseButton().getLocation();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(point.getX(), 411);
        softAssert.assertEquals(point.getY(), 269);
        softAssert.assertAll();
    }
}