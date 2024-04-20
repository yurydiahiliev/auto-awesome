package com.plexusworldwide.pages;

import org.openqa.selenium.By;

import static com.plexusworldwide.utils.LocatorUtils.byDataTestId;

public class ShopPage extends BasePage {

    private By pageHeadingLabel = byDataTestId("h1-heading");

    public boolean isOnPage() {
        return driver.getCurrentUrl().contains("/products")
               && getText(pageHeadingLabel, "Shop page heading label")
                   .equals("Product Categories");
    }
}