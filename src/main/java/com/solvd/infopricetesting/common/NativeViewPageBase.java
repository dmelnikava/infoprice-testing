package com.solvd.infopricetesting.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NativeViewPageBase extends AbstractPage {

    public NativeViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickMenuBtn();

    public abstract void clickBookmark();

    public abstract String getBookmarkMessage();

}