package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends AbstractPage {

    private final By onHomePageButton = By.linkText("главную страницу");

    public BasketPage(WebDriver driver){
        super(driver);
        if (!waitDriver().until(ExpectedConditions.titleIs("infoprice.by | Список покупок"))) {
            throw new IllegalStateException("This is not Basket Page");
        }
    }

    public HomePage clickOnHomePage() {
        waitDriver().until(ExpectedConditions.elementToBeClickable(onHomePageButton)).click();
        return new HomePage(getDriver());
    }
}