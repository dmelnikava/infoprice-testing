package com.solvd.infopricetesting.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.infopricetesting.common.BasketPageBase;
import com.solvd.infopricetesting.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, version = "16.2", parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase implements IMobileUtils {

    @FindBy(css = "head > title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(text(), 'главную страницу')]")
    private ExtendedWebElement onHomePageButton;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public HomePageBase clickOnHomePage() {
        onHomePageButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}