package com.plexusworldwide.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class WebDriverWaitUtils {

    private static int defaultTimeoutInSeconds = 10;
    private static WebDriver driver = DriverManager.getDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, defaultTimeoutInSeconds);

    public static WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitForListWebElementsToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForSizeInListWebElements(By locator, int expectedSizeMoreThan) {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, expectedSizeMoreThan));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
