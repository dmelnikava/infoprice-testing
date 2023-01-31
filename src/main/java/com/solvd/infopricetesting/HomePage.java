package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends AbstractPage{

    private final By filterButton = By.cssSelector(".filter-menu .name-button");
    private final By filterButtonLocation = By.xpath("//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]");
    private final By filterBarShowStatus = By.xpath("//*[@class='collapse show']");
    private final By filterComponents = By.xpath("//*[@class='list-filter components']");
    private final By basketIcon = By.cssSelector(".cart-img");
    private final By closeButton = By.cssSelector("button.navbar-filters .close-button ");

    public HomePage(WebDriver driver){
        super(driver);
        verifyTitle(Duration.ofSeconds(30), "INFOPRICE — сервис сравнения цен на продукты в магазинах Минска");
    }

    public HomePage clickFilterButton() {
        clickWebElement(Duration.ofSeconds(30), filterButton);
        return this;
    }

    public BasketPage clickBasketIcon() {
        clickWebElement(Duration.ofSeconds(30), basketIcon);
        return new BasketPage(getDriver());
    }

    public HomePage clickCloseButton() {
        clickWebElement(Duration.ofSeconds(30), closeButton);
        return this;
    }

    public WebElement getFilterBarShowStatus() {
        return getWebElement(Duration.ofSeconds(30), filterBarShowStatus);
    }

    public WebElement getFilterButtonLocation() {
        return getWebElement(Duration.ofSeconds(30), filterButtonLocation);
    }

    public WebElement getCloseButton() {
        return getWebElement(Duration.ofSeconds(30), closeButton);
    }

    public WebElement getFilterComponents() {
        return getWebElement(Duration.ofSeconds(30), filterComponents);
    }
}