package com.plexusworldwide.pages;

import com.plexusworldwide.driver.DriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class PageManager {

    private static final String BASE_URL = "https://plexusworldwide.com";
    private static WebDriver driver = DriverManager.getDriver();

    public static <T extends BasePage> T open(Class<T> pageClass) {
        Map<Class<? extends BasePage>, String> pageHolder = new HashMap<>();
        pageHolder.put(HomePage.class, "/");
        pageHolder.put(ShopPage.class, "/products");

        String urlPrefix = pageHolder.getOrDefault(pageClass, StringUtils.EMPTY);

        driver.get(BASE_URL + urlPrefix);
        return at(pageClass);
    }

    public static <T extends BasePage> T at(Class<T> pageClass) {
        T classInstance;
        try {
            classInstance = pageClass.getDeclaredConstructor().newInstance();
        }  catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return classInstance;
    }
}