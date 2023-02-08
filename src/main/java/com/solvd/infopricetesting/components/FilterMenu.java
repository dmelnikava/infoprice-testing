package com.solvd.infopricetesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.infopricetesting.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilterMenu extends AbstractUIObject {
    @FindBy(xpath = ".//*[@id='sidebar-filter']")
    private ExtendedWebElement filterList;

    @FindBy(css = ".filter-menu .name-button")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//*[@id='sidebar-filter'][@class='collapse show']")
    private ExtendedWebElement filterShowStatus;

    @FindBy(xpath = "//*[@class='custom-control-label'][@for='-1']")
    private ExtendedWebElement allShopsCheckBox;

    @FindBy(xpath = "//*[@class='scroll-filter']//*[@type='checkbox']")
    private List<ExtendedWebElement> filterCheckBoxes;

    private final By closeButton = By.cssSelector(".close-button");

    public FilterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WebElement getFilterShowStatus() {
        return filterShowStatus.getElement();
    }

    public List<WebElement> getFilterCheckBoxes() {
        List<WebElement> elements = new ArrayList<>();
        for (ExtendedWebElement filterCheckbox : filterCheckBoxes) {
            WebElement element = filterCheckbox.getElement();
            elements.add(element);
        }
        return elements;
    }

    public WebElement getCloseButton() {
        return getDriver().findElement(closeButton);
    }

    public void clickAllShopsCheckBox() {
        allShopsCheckBox.click();
    }

    public HomePage clickFilterButton() {
        if(filterButton.isClickable()) {
            filterButton.click();
        }
        return new HomePage(getDriver());
    }

    public HomePage clickCloseButton() {
        WebElement element = driver.findElement(closeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new HomePage(getDriver());
    }
}