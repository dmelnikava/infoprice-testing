package com.solvd.infopricetesting.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasketPageBase extends AbstractPage {

    public BasketPageBase(WebDriver driver){
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract HomePageBase clickOnHomePage();

}