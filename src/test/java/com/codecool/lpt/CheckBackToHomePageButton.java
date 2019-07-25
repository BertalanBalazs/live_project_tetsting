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
        String mainPageUrl = mainPage.navigate()
                .getCurrentUrl();

        String actualUrl = mainPage.clickOnShoppingCart()
                .clickBackToHomePageButton()
                .getCurrentUrl();

        assertEquals(mainPageUrl, actualUrl, "Not the same!");

    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }
}