package com.plexusworldwide.tests;

import com.plexusworldwide.pages.HomePage;
import com.plexusworldwide.pages.ShopPage;
import org.testng.annotations.Test;

import java.util.*;

import static com.plexusworldwide.pages.HomePage.MainLeftBarMenu.SHOP;
import static com.plexusworldwide.pages.PageManager.at;
import static com.plexusworldwide.pages.PageManager.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainLeftNavBarMenuTest extends BaseTest {

    @Test(priority = 1)
    public void userCanChecksMainNavBarMenuItems() {
        List<String> actualMainLeftMenuLabels = open(HomePage.class).getMainLeftBarMenuLabels();
        assertEquals(HomePage.MainLeftBarMenu.getNames(), actualMainLeftMenuLabels);
    }

    @Test(priority = 2)
    public void userCanNavigateToShopMainLeftBarMenu() {
        ShopPage shopPage = at(HomePage.class).clickOnNavLeftBarItem(SHOP);
        assertTrue(shopPage.isOnPage());
    }
}