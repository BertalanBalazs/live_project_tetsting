package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void searchInTheTitleAndDescription() {
        mainPage.navigate()
                .sendKeyToSearchInput("land")
                .clickToSearchButton();

        assertTrue(mainPage.isElementDisplayedOnTheScreen("Scar"), "No match found");
        assertTrue(mainPage.isElementDisplayedOnTheScreen("Simba"), "No match found");
    }
}