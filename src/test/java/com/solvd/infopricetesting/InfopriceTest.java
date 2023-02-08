package com.solvd.infopricetesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.infopricetesting.components.FilterMenu;
import com.solvd.infopricetesting.pages.BasketPage;
import com.solvd.infopricetesting.pages.HomePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.infopricetesting.utils.MutableCaps.deployCapabilities;

public class InfopriceTest implements IAbstractTest {

    @Parameters({"browserName"})
    @Test(testName = "Check returning from the Basket page to the Home page")
    public void checkReturnFromBasketPageToHomePageTest(String browserName) {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        BasketPage basketPage = homePage.clickBasketIcon();
        HomePage returnedHomePage = basketPage.clickOnHomePage();

        softAssert.assertTrue(returnedHomePage.isPageOpened(10), "Home page is not opened");

        softAssert.assertEquals(getDriver(browserName, deployCapabilities(browserName)).getCurrentUrl(), "https://infoprice.by/", "Home page is not opened");

        softAssert.assertAll();
    }

    @Parameters({"browserName"})
    @Test(testName = "Check if the Filter menu locates under Catalog menu")
    public void checkFilterMenuLocationTest(String browserName) {
        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        Assert.assertNotNull(homePage.getFilterButtonLocation(), "Filter button is not located in the right place");
    }

    @Parameters({"browserName"})
    @Test(testName = "Check the opening of the Filter menu by clicking on the text")
    public void checkOpenFilterMenuTest(String browserName) {
        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        FilterMenu filterMenu = homePage.getFilterMenu();

        WebElement filterStatusBar = filterMenu.getFilterShowStatus();

        Assert.assertEquals(filterStatusBar.getAttribute("class"), "collapse show",
                "Filter menu is not opened by clicking on the menu icon");
    }

    @Parameters({"browserName"})
    @Test(testName = "Check if the Close button is present to close the Filter menu")
    public void checkCloseButtonLocationTest(String browserName) {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        FilterMenu filterMenu = homePage.getFilterMenu();
        if(filterMenu.isUIObjectPresent()) {
            Point point = filterMenu.getCloseButton().getLocation();
            softAssert.assertEquals(point.getX(), 643, "Close button is not located in the right place");
            softAssert.assertEquals(point.getY(), 270, "Close button is not located in the right place");
        }

        softAssert.assertAll();
    }

    @Parameters({"browserName"})
    @Test(testName = "Check closing the Filter menu by clicking Close button")
    public void checkCloseFilterMenuTest(String browserName) {
        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        FilterMenu filterMenu = homePage.getFilterMenu();

        HomePage returnedHomePage = filterMenu.clickCloseButton();

        WebElement filterMenuStatus = returnedHomePage.getFilterUnshowStatus();

        Assert.assertEquals(filterMenuStatus.getAttribute("class"), "collapse",
                "Filter menu was not close by clicking Close button");
    }

    @Parameters({"browserName"})
    @Test(testName = "Check the option to enable the All shops function in the Filter menu")
    public void checkOptionAllShopsTest(String browserName) {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver(browserName, deployCapabilities(browserName)));
        homePage.open();

        FilterMenu filterMenu = homePage.getFilterMenu();
        filterMenu.clickAllShopsCheckBox();

        for(int i = 0; i <= 10; i++) {
            boolean isSelected = filterMenu.getFilterCheckBoxes().get(i).isSelected();
            softAssert.assertTrue(isSelected, "Checkbox of the shop was not selected");
        }

        HomePage returnedHomePage = filterMenu.clickFilterButton();

        for(int i = 0; i <= 9; i++) {
            boolean isDisplayed = returnedHomePage.getFilterTags().get(i).isDisplayed();
            softAssert.assertTrue(isDisplayed, "Tag of the shop is not displayed");
        }

        softAssert.assertAll();
    }
}