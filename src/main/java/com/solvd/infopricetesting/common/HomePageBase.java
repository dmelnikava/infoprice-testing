package com.solvd.infopricetesting.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver){
        super(driver);
        setPageURL("");
    }

    public abstract boolean isPageOpened();

    public abstract void openFilterMenu();

    public abstract WebElement getFilterUnshowStatus();

    public abstract WebElement getFilterButtonLocation();

    public abstract List<WebElement> getFilterTags();

    public abstract WebElement getFilterShowStatus();

    public abstract List<WebElement> getFilterCheckBoxes();

    public abstract WebElement getCloseButton();

    public abstract void clickAllShopsCheckBox();

    public abstract void clickFilterButton();

    public abstract void clickCloseButton();

    public abstract BasketPageBase clickBasketIcon();

    public abstract String getTextOfTitle();

}