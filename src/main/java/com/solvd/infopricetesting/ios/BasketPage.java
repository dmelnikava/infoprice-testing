package com.solvd.infopricetesting.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.infopricetesting.common.BasketPageBase;
import com.solvd.infopricetesting.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, version = "16.2", parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "label == 'infoprice.by | Список покупок'")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == 'главную страницу'`]")
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
//        waitUntil(ExpectedConditions.visibilityOf(onHomePageButton.getElement()), 50);
        onHomePageButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}