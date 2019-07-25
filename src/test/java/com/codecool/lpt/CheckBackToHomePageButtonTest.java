package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBackToHomePageButtonTest extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void checkBackToHomePageButton() {
        String mainPageUrl = mainPage.navigate()
                .getCurrentUrl();

        String actualUrl = mainPage.clickOnShoppingCart()
                .clickBackToHomePageButton()
                .getCurrentUrl();

        assertEquals(mainPageUrl, actualUrl, "Not the same!");
    }
}