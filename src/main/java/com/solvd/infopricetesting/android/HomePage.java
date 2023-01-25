package com.solvd.infopricetesting.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.infopricetesting.common.BasketPageBase;
import com.solvd.infopricetesting.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, version = "11.0", parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(css = "head > title")
    private ExtendedWebElement title;

    @FindBy(css = ".fas.fa-sliders-h")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]")
    private ExtendedWebElement filterButtonLocation;

    @FindBy(xpath = ".//*[@id='sidebar-filter']")
    private ExtendedWebElement filterList;

    @FindBy(xpath = "//*[@id='sidebar-filter'][@class='collapse show']")
    private ExtendedWebElement filterShowStatus;

    @FindBy(xpath = "//*[@class='custom-control-label'][@for='-1']")
    private ExtendedWebElement allShopsCheckBox;

    @FindBy(xpath = "//*[@class='scroll-filter']//*[@type='checkbox']")
    private List<ExtendedWebElement> filterCheckBoxes;

    @FindBy(xpath = "//*[@id='sidebar-filter'][@class='collapse']")
    private ExtendedWebElement filterUnshowStatus;

    @FindBy(xpath = "//*[@class='tag-filter']//*[@href='#']")
    private List<ExtendedWebElement> filterTags;

    @FindBy(css = ".cart-img")
    private ExtendedWebElement basketIcon;

    private final By closeButton = By.cssSelector(".close-button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isPresent(10L);
    }

    @Override
    public void openFilterMenu() {
        filterButton.click();
    }

    @Override
    public WebElement getFilterUnshowStatus() {
        return filterUnshowStatus.getElement();
    }

    @Override
    public WebElement getFilterButtonLocation() {
        return filterButtonLocation.getElement();
    }

    @Override
    public WebElement getFilterShowStatus() {
        return filterShowStatus.getElement();
    }

    @Override
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    @Override
    public void clickAllShopsCheckBox() {
        allShopsCheckBox.click();
    }

    @Override
    public List<WebElement> getFilterCheckBoxes() {
        List<WebElement> elements = new ArrayList<>();
        for (ExtendedWebElement filterCheckbox : filterCheckBoxes) {
            WebElement element = filterCheckbox.getElement();
            elements.add(element);
        }
        return elements;
    }

    @Override
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

    @Override
    public void clickFilterButton() {
        if(filterButton.isClickable()) {
            filterButton.click();
        }
    }

    @Override
    public void clickCloseButton() {
        WebElement element = driver.findElement(closeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    @Override
    public BasketPageBase clickBasketIcon() {
        basketIcon.click();
        return initPage(getDriver(), BasketPageBase.class);
    }
}