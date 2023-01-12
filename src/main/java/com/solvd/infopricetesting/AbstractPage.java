package com.solvd.infopricetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    private static WebDriver driver;

    public AbstractPage(WebDriver driver) {
        setDriver(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebDriverWait waitDriver() {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}