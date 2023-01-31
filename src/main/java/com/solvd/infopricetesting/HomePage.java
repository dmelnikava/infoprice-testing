package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HomePage extends AbstractPage{

    private final By filterButton = By.cssSelector(".filter-menu .name-button");
    private final By filterButtonLocation = By.xpath("//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]");
    private final By filterShowStatus = By.xpath("//*[@id='sidebar-filter'][@class='collapse show']");
    private final By filterUnshowStatus = By.xpath("//*[@id='sidebar-filter'][@class='collapse']");
    private final By basketIcon = By.cssSelector(".cart-img");
    private final By closeButton = By.cssSelector(".close-button");
    private final By allShopsCheckBox = By.xpath("//*[@class='custom-control-label'][@for='-1']");
    private final By filterCheckBoxes = By.xpath("//*[@class='scroll-filter']//*[@type='checkbox']");
    private final By filterTags = By.xpath("//*[@class='tag-filter']//*[@href='#']");

    public HomePage(WebDriver driver){
        super(driver);
        verifyTitle(Duration.ofSeconds(40), "INFOPRICE — сервис сравнения цен на продукты в магазинах Минска");
    }

    public HomePage clickFilterButton() {
        clickWebElement(Duration.ofSeconds(30), filterButton);
        return this;
    }

    public BasketPage clickBasketIcon() {
        clickWebElement(Duration.ofSeconds(100), basketIcon);
        return new BasketPage(getDriver());
    }

    public HomePage clickCloseButton() {
        clickWebElement(Duration.ofSeconds(100), closeButton);
        return this;
    }

    public WebElement getFilterShowStatus() {
        return getWebElement(Duration.ofSeconds(30), filterShowStatus);
    }

    public WebElement getFilterUnshowStatus() {
        return getWebElement(Duration.ofSeconds(30), filterUnshowStatus);
    }

    public WebElement getFilterButtonLocation() {
        return getWebElement(Duration.ofSeconds(30), filterButtonLocation);
    }

    public WebElement getCloseButton() {
        return getWebElement(Duration.ofSeconds(30), closeButton);
    }

    public HomePage clickAllShopsCheckBox() {
        clickCheckBox(Duration.ofSeconds(30), allShopsCheckBox);
        return this;
    }

    public List<WebElement> getFilterCheckBoxes() {
        return getWebElements(Duration.ofSeconds(100), filterCheckBoxes);
    }

    public List<WebElement> getFilterTags() {
        return getWebElements(Duration.ofSeconds(30), filterTags);
    }
}