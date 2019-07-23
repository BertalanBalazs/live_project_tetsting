package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {
    private MainPage mainPage;

    @Test
    void searchInTheTitleAndDescription() {
        mainPage.navigate();
        mainPage.sendKeyToSearchInput("land");
        mainPage.clickToSearchButton();
        assertTrue(mainPage.isElementDisplayedOnTheScreen("Scar"), "No match found");
        assertTrue(mainPage.isElementDisplayedOnTheScreen("Simba"), "No match found");
    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }
}