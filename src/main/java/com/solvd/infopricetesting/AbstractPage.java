package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    private static WebDriver driver;

    public AbstractPage(WebDriver driver) {
        setDriver(driver);
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void verifyTitle(Duration duration, String title) {
        WebDriverWait wait = waitDriver(duration);
        if(!wait.until(ExpectedConditions.titleIs(title))) {
            throw new IllegalStateException("This is not correct page");
        }
    }

    public void clickWebElement(Duration duration, By locator) {
        WebDriverWait wait = waitDriver(duration);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement getWebElement(Duration duration, By locator) {
        return waitDriver(duration).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebDriverWait waitDriver(Duration duration) {
        return new WebDriverWait(driver, duration);
    }
}