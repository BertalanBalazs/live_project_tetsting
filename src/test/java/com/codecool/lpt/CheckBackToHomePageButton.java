package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBackToHomePageButton extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Test
    void searchInTheTitleAndDescription() {
        mainPage.navigate();
        String mainPageUrl = mainPage.getCurrentUrl();
        mainPage.clickOnShoppingCart();
        shoppingCartPage.clickBackToHomePageButton();
        String actualUrl = mainPage.getCurrentUrl();
        assertEquals(mainPageUrl, actualUrl, "Not the same!");

    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }
}