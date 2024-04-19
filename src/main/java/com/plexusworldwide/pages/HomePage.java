package com.plexusworldwide.pages;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;

import java.util.*;
import java.util.stream.Collectors;

import static com.plexusworldwide.pages.PageManager.at;
import static com.plexusworldwide.utils.LocatorUtils.getCssByDataTestId;
import static java.util.stream.Collectors.toList;

public class HomePage extends BasePage {

    private By mainNavLeftBarMenuItems = By.cssSelector("ul[class*='leftNav'] " + getCssByDataTestId("menu-item-content-copy"));

    public List<String> getMainLeftBarMenuLabels() {
        return getTexts(mainNavLeftBarMenuItems);
    }

    public <T extends BasePage> T clickOnNavLeftBarItem(MainLeftBarMenu mainLeftBarMenu) {
        clickOnElement(mainLeftBarMenu.getLocator());
        return (T) at(mainLeftBarMenu.getPageClass());
    }

    public enum MainLeftBarMenu {
        SHOP("products", ShopPage.class),
        EXPERIENCE_PLEXUS("experience-plexus", null),
        ABOUT("about", null),
        RESOURCES("resources", null),
        JOIN("join", null);

        private final String menuName;
        private final Class<? extends BasePage> pageClass;

        MainLeftBarMenu(String menuName, Class<? extends BasePage> pageClass) {
            this.menuName = menuName;
            this.pageClass = pageClass;
        }

        public By getLocator() {
            return By.cssSelector(getCssByDataTestId("main-header-option") + " a[href*='" + menuName + "']");
        }

        public Class<? extends BasePage> getPageClass() {
            return pageClass;
        }

        public static List<String> getNames() {
            return Arrays.stream(MainLeftBarMenu.values())
                .map(MainLeftBarMenu::name)
                .map(str -> str.replace("_", " "))
                .map(String::toLowerCase)
                .map(WordUtils::capitalizeFully)
                .collect(toList());
        }
    }
}
