package com.plexusworldwide.pages;

import com.plexusworldwide.driver.DriverManager;
import com.plexusworldwide.driver.WebDriverWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForElementToBeClickable;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForListWebElementsToBeVisible;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForSizeInListWebElements;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForVisibilityOfElement;
import static java.util.stream.Collectors.toList;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
    }

    public void clickOnElement(By by) {
        waitForVisibilityOfElement(by);
        WebElement element = waitForElementToBeClickable(by);
        element.click();
    }

    public String getText(By by) {
        return waitForVisibilityOfElement(by).getText();
    }

    public List<String> getTexts(By by) {
        waitForListWebElementsToBeVisible(by);
        List<WebElement> elements = waitForSizeInListWebElements(by, 0);
        return elements.stream()
                       .map(WebElement::getText)
                       .collect(toList());
    }
}