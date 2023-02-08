package com.solvd.infopricetesting.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.openqa.selenium.MutableCapabilities;

public class MutableCaps implements IAbstractTest {

    public static MutableCapabilities deployCapabilities(String browserName) {
        MutableCapabilities capabilities = new MutableCapabilities();

        if(browserName.equals("chrome")) {
            capabilities.setCapability("browserName", "chrome");
        } else if(browserName.equals("firefox")) {
            capabilities.setCapability("browserName", "firefox");
        }

        return capabilities;
    }
}