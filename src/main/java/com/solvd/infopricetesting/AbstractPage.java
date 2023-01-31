package com.solvd.infopricetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        WebElement element = waitDriver(duration).until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void clickCheckBox(Duration duration, By locator) {
        WebDriverWait wait = waitDriver(duration);
        WebElement checkBoxElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean isSelected = checkBoxElement.isSelected();
        if(!isSelected) {
            checkBoxElement.click();
        }
    }

    public WebElement getWebElement(Duration duration, By locator) {
        return waitDriver(duration).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> getWebElements(Duration duration, By locator) {
        return waitDriver(duration).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public WebDriverWait waitDriver(Duration duration) {
        return new WebDriverWait(driver, duration);
    }
}