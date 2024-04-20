package com.plexusworldwide.pages;

import com.plexusworldwide.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForElementToBeClickable;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForListWebElementsToBeVisible;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForSizeInListWebElements;
import static com.plexusworldwide.driver.WebDriverWaitUtils.waitForVisibilityOfElement;
import static java.util.stream.Collectors.toList;

public class BasePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        driver = DriverManager.getDriver();
    }

    public void clickOnElement(By by, String elementLabel) {
        waitForVisibilityOfElement(by);
        WebElement element = waitForElementToBeClickable(by);
        element.click();
        log.info("Clicked on web element: {}", elementLabel);
    }

    public String getText(By by, String elementLabel) {
        String actualElementText = waitForVisibilityOfElement(by).getText();
        log.info("Element {} has text is: {}", elementLabel, actualElementText);
        return actualElementText;
    }

    public List<String> getTexts(By by, String elementLabel) {
        waitForListWebElementsToBeVisible(by);
        List<WebElement> elements = waitForSizeInListWebElements(by, 0);
        List<String> actualElementsTexts = elements.stream().map(WebElement::getText).collect(toList());
        log.info("List of elements: {} has texts: {}", elementLabel, actualElementsTexts);
        return actualElementsTexts;
    }
}