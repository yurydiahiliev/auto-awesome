package com.plexusworldwide.tests;

import com.plexusworldwide.driver.Browser;
import com.plexusworldwide.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private Browser browser;

    @BeforeClass
    public void setUp() {
        browser = new Browser();
        DriverManager.setDriver(browser.getDriver());
    }

    @AfterClass
    public void tearDown() {
        browser.close();
    }
}