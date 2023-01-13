package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By filterButton = By.cssSelector(".filter-menu .name-button");
    private By filterButtonLocation = By.xpath("//*[contains(text(), 'Каталог')]/../../../..//*[contains(text(), 'Фильтр')]");
    private By filterBarShowStatus = By.xpath("//*[@class='collapse show']");
    private By basketIcon = By.cssSelector(".cart-img");

    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("INFOPRICE — сервис сравнения цен на продукты в магазинах Минска")) {
            throw new IllegalStateException("This is not Home Page");
        }
    }

    public WebElement getFilterBarShowStatus() {
        return driver.findElement(filterBarShowStatus);
    }

    public WebElement getFilterButtonLocation() {
        return driver.findElement(filterButtonLocation);
    }

    public void clickFilterButton() {
        driver.findElement(filterButton).click();
    }

    public BasketPage clickBasketIcon() {
        driver.findElement(basketIcon).click();
        return new BasketPage(driver);
    }
}