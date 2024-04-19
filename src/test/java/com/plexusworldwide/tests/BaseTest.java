package com.plexusworldwide.tests;

import com.plexusworldwide.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        DriverManager.setDriver(new ChromeDriver());
    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
