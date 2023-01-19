package com.solvd.infopricetesting.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.infopricetesting.components.FilterMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(css = "head > title")
    private ExtendedWebElement title;

    @FindBy(css = ".list-filter.components")
    private FilterMenu filterMenu;

    @FindBy(css = ".filter-menu .name-button")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]")
    private ExtendedWebElement filterButtonLocation;

    @FindBy(xpath = "//*[@id='sidebar-filter'][@class='collapse']")
    private ExtendedWebElement filterUnshowStatus;

    @FindBy(xpath = "//*[@class='tag-filter']//*[@href='#']")
    private List<ExtendedWebElement> filterTags;

    @FindBy(css = ".cart-img")
    private ExtendedWebElement basketIcon;

    public HomePage(WebDriver driver){
        super(driver);
        setPageURL("");
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public FilterMenu getFilterMenu() {
        filterButton.click();
        return filterMenu;
    }

    public WebElement getFilterUnshowStatus() {
        return filterUnshowStatus.getElement();
    }

    public WebElement getFilterButtonLocation() {
        return filterButtonLocation.getElement();
    }

    public List<WebElement> getFilterTags() {
        List<WebElement> elements = new ArrayList<>();
        for (ExtendedWebElement filterTag : filterTags) {
            if (filterTag.isPresent()) {
                WebElement element = filterTag.getElement();
                elements.add(element);
            }
        }
        return elements;
    }

    public BasketPage clickBasketIcon() {
        basketIcon.click();
        return new BasketPage(getDriver());
    }
}