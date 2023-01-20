package com.solvd.infopricetesting.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.infopricetesting.pages.HomePage;
import com.zebrunner.carina.utils.commons.SpecialKeywords;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

public class MutableCaps implements IAbstractTest {

    public static MutableCapabilities deployCapabilities(String browserName) {
        MutableCapabilities capabilities = new MutableCapabilities();

        if(browserName.equals("chrome")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME.browserName());
        } else if(browserName.equals("firefox")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.FIREFOX.browserName());
        }
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, SpecialKeywords.MAC);

        return capabilities;
    }
}