package com.solvd.infopricetesting.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.infopricetesting.common.NativeViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, version = "11.0", parentClass = NativeViewPageBase.class)
public class NativeViewPage extends NativeViewPageBase {

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement chromeMenuBtn;

    @FindBy(id = "com.android.chrome:id/button_two")
    private ExtendedWebElement bookmark;

    @FindBy(id = "com.android.chrome:id/snackbar_message")
    private ExtendedWebElement bookmarkMessage;

    public NativeViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickChromeMenuBtn() {
        chromeMenuBtn.click();
    }

    @Override
    public void clickBookmark() {
        bookmark.click();
    }

    @Override
    public String getBookmarkMessage() {
        return bookmarkMessage.getText();
    }
}