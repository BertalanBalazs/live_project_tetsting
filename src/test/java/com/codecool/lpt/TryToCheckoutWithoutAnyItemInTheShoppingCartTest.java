package com.codecool.lpt;

import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TryToCheckoutWithoutAnyItemInTheShoppingCartTest extends BaseTest {
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void tryToCheckOutWithoutAnyItemInTheShoppingCart() {
        shoppingCartPage.navigateToShoppingCartPage()
                .clearShoppingCart();

        assertFalse(shoppingCartPage.checkCheckoutButtonIsDisplayed(), "Checkout button is visible, but the shopping cart is empty!");
    }
}