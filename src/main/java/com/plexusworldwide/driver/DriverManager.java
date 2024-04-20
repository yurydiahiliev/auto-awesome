package com.plexusworldwide.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final static Logger log = LoggerFactory.getLogger(DriverManager.class);

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
        log.info("Driver was set in thread id: " + Thread.currentThread().getId());
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            log.info("Driver was closed or null. Going to create new driver!");
            WebDriverManager.chromedriver().setup();
            driver.set(new Browser().getDriver());
        }
        return driver.get();
    }
}