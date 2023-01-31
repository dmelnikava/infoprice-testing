package com.solvd.infopricetesting.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.infopricetesting.common.BasketPageBase;
import com.solvd.infopricetesting.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, version = "16.2", parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(css = "head > title")
    private ExtendedWebElement title;

    @FindBy(css = ".fas.fa-sliders-h")
    private ExtendedWebElement filterButton;

    @FindBy(css = ".fas.fa-sliders-h")
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

    @FindBy(css = ".close-button")
    private ExtendedWebElement closeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
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
        return closeButton.getElement();
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
        closeButton.click();
    }

    @Override
    public BasketPageBase clickBasketIcon() {
        basketIcon.click();
        return initPage(getDriver(), BasketPageBase.class);
    }

    public String getTextOfTitle() {
        return title.getElement().getText();
    }
}