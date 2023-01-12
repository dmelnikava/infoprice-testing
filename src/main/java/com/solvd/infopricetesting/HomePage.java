package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage{

    private final By filterButton = By.cssSelector(".filter-menu .name-button");
    private final By filterButtonLocation = By.xpath("//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]");
    private final By filterBarShowStatus = By.xpath("//*[@class='collapse show']");
    private final By basketIcon = By.cssSelector(".cart-img");

    public HomePage(WebDriver driver){
        super(driver);
        if (!waitDriver().until(ExpectedConditions.titleIs("INFOPRICE — сервис сравнения цен на продукты в магазинах Минска"))) {
            throw new IllegalStateException("This is not Home Page");
        }
    }

    public HomePage clickFilterButton() {
        waitDriver().until(ExpectedConditions.elementToBeClickable(filterButton)).click();
        return this;
    }

    public BasketPage clickBasketIcon() {
        waitDriver().until(ExpectedConditions.elementToBeClickable(basketIcon)).click();
        return new BasketPage(getDriver());
    }

    public WebElement getFilterBarShowStatus() {
        return waitDriver().until(ExpectedConditions.presenceOfElementLocated(filterBarShowStatus));
    }

    public WebElement getFilterButtonLocation() {
        return waitDriver().until(ExpectedConditions.presenceOfElementLocated(filterButtonLocation));
    }
}