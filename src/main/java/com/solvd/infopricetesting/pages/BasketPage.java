package com.solvd.infopricetesting.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage {

    @FindBy(css = "head > title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(text(), 'главную страницу')]")
    private ExtendedWebElement onHomePageButton;

    public BasketPage(WebDriver driver){
        super(driver);
        setPageAbsoluteURL("https://infoprice.by/cart");
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public HomePage clickOnHomePage() {
        onHomePageButton.click();
        return new HomePage(getDriver());
    }
}