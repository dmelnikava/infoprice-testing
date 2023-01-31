package com.solvd.infopricetesting.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.infopricetesting.common.NativeViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, version = "16.2", parentClass = NativeViewPageBase.class)
public class NativeViewPage extends NativeViewPageBase {

    @ExtendedFindBy(iosPredicate = "label == 'Share'")
    private ExtendedWebElement shareBtn;

    @ExtendedFindBy(iosPredicate = "label == 'bookmark'")
    private ExtendedWebElement bookmark;

    @ExtendedFindBy(iosPredicate = "label == 'Save'")
    private ExtendedWebElement saveBtn;

    public NativeViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuBtn() {
        shareBtn.click();
    }

    public void clickBookmark() {
        bookmark.click();
    }

    @Override
    public String getBookmarkMessage() {
        String message = "Failed to add bookmark";
        if(saveBtn.isElementPresent()) {
            saveBtn.click();
            message = "Bookmarked";
        }
        return message;
    }
}