package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasketPage extends AbstractPage {

    private final By onHomePageButton = By.xpath("//*[contains(text(), 'главную страницу')]");

    public BasketPage(WebDriver driver){
        super(driver);
        verifyTitle(Duration.ofSeconds(50), "infoprice.by | Список покупок");
    }

    public HomePage clickOnHomePage() {
        clickWebElement(Duration.ofSeconds(100), onHomePageButton);
        return new HomePage(getDriver());
    }
}