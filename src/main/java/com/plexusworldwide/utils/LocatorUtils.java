package com.plexusworldwide.utils;

import org.openqa.selenium.By;

public class LocatorUtils {

    public static String getCssByDataTestId(String locator) {
        return String.format("[data-testid='%s']", locator);
    }

    public static By byDataTestId(String locator) {
        return By.cssSelector(getCssByDataTestId(locator));
    }
}