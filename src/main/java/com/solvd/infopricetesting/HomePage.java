package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractPage{

    private final By filterButton = By.cssSelector(".filter-menu .name-button");
    private final By filterButtonLocation = By.xpath("//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]");
    private final By filterBarShowStatus = By.xpath("//*[@class='collapse show']");
    private final By basketIcon = By.cssSelector(".cart-img");
    private final By closeButton = By.cssSelector(".close-button");

    public HomePage(WebDriver driver){
        super(driver);
        verifyTitle(Duration.ofSeconds(15), "INFOPRICE — сервис сравнения цен на продукты в магазинах Минска");
    }

    public HomePage clickFilterButton() {
        clickWebElement(Duration.ofSeconds(15), filterButton);
        return this;
    }

    public BasketPage clickBasketIcon() {
        clickWebElement(Duration.ofSeconds(15), basketIcon);
        return new BasketPage(getDriver());
    }

    public HomePage clickCloseButton() {
        clickWebElement(Duration.ofSeconds(15), closeButton);
        return this;
    }

    public WebElement getFilterBarShowStatus() {
        return getWebElement(Duration.ofSeconds(15), filterBarShowStatus);
    }

    public WebElement getFilterButtonLocation() {
        return getWebElement(Duration.ofSeconds(15), filterButtonLocation);
    }

    public WebElement getCloseButton() {
        return getWebElement(Duration.ofSeconds(15), closeButton);
    }
}