package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private WebDriver driver;
    private By onHomePageButton = By.linkText("главную страницу");

    public BasketPage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("infoprice.by | Список покупок")) {
            throw new IllegalStateException("This is not Basket Page");
        }
    }

    public HomePage clickOnHomePageButton() {
        driver.findElement(onHomePageButton).click();
        return new HomePage(driver);
    }
}