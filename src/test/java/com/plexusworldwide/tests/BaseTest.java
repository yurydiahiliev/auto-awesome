package com.plexusworldwide.tests;

import com.plexusworldwide.driver.Browser;
import com.plexusworldwide.driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private Browser browser;

    @BeforeClass
    public void setUp() {
        browser = new Browser();
        DriverManager.setDriver(browser.getChromeDriver());
    }

    @AfterClass
    public void tearDown() {
        browser.close();
    }
}