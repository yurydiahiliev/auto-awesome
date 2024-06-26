package com.plexusworldwide.driver;

import com.plexusworldwide.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Browser {

    private WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(Browser.class);

    public WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "--disable-notifications",
            "--disable-web-security",
            "--ignore-certificate-errors",
            "--allow-running-insecure-content",
            "--allow-insecure-localhost",
            "--no-sandbox",
            "--disable-gpu");
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(PropertyUtils.getBrowserTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Registered new driver in thread id: " + Thread.currentThread().getId());
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
            log.info("Driver was closed in thread id: " + Thread.currentThread().getId());
        }
    }
}