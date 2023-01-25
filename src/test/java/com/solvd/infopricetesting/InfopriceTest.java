package com.solvd.infopricetesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.infopricetesting.common.BasketPageBase;
import com.solvd.infopricetesting.common.HomePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InfopriceTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Check returning from the Basket page to the Home page")
    public void checkReturnFromBasketPageToHomePageTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        BasketPageBase basketPage = homePage.clickBasketIcon();
        HomePageBase returnedHomePage = basketPage.clickOnHomePage();

        softAssert.assertTrue(returnedHomePage.isPageOpened(10), "Home page is not opened");

        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://infoprice.by/",
                "Home page is not opened");

        softAssert.assertAll();
    }

    @Test(testName = "Check if the Filter menu locates under Catalog menu")
    public void checkFilterMenuLocationTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        Assert.assertNotNull(homePage.getFilterButtonLocation(), "Filter button is not located in the right place");
    }

    @Test(testName = "Check the opening of the Filter menu by clicking on the text")
    public void checkOpenFilterMenuTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        homePage.openFilterMenu();

        WebElement filterStatusBar = homePage.getFilterShowStatus();

        Assert.assertEquals(filterStatusBar.getAttribute("class"), "collapse show",
                "Filter menu is not opened by clicking on the menu icon");
    }

    @Test(testName = "Check if the Close button is present to close the Filter menu")
    public void checkCloseButtonLocationTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.openFilterMenu();

        WebElement closeButton = homePage.getCloseButton();
        if(closeButton.isEnabled()) {
            Point point = closeButton.getLocation();
            softAssert.assertEquals(point.getX(), 367, "Close button is not located in the right place");
            softAssert.assertEquals(point.getY(), 20, "Close button is not located in the right place");
        }

        softAssert.assertAll();
    }

    @Test(testName = "Check closing the Filter menu by clicking Close button")
    public void checkCloseFilterMenuTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.openFilterMenu();
        homePage.clickCloseButton();

        WebElement filterMenuStatus = homePage.getFilterUnshowStatus();

        Assert.assertEquals(filterMenuStatus.getAttribute("class"), "collapse",
                "Filter menu was not close by clicking Close button");
    }

    @Test(testName = "Check the option to enable the All shops function in the Filter menu")
    public void checkOptionAllShopsTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.openFilterMenu();
        homePage.clickAllShopsCheckBox();

        for(int i = 0; i <= 10; i++) {
            boolean isSelected = homePage.getFilterCheckBoxes().get(i).isSelected();
            softAssert.assertTrue(isSelected, "Checkbox of the shop was not selected");
        }

        homePage.clickCloseButton();

        for(int i = 0; i <= 9; i++) {
            boolean isDisplayed = homePage.getFilterTags().get(i).isDisplayed();
            softAssert.assertTrue(isDisplayed, "Tag of the shop is not displayed");
        }

        softAssert.assertAll();
    }
}