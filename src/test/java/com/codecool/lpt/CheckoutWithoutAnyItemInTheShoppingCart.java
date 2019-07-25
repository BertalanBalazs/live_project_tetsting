package com.codecool.lpt;

import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutWithoutAnyItemInTheShoppingCart extends BaseTest {
    private ShoppingCartPage shoppingCartPage;

    @Test
    void searchInTheTitleAndDescription() {
        shoppingCartPage.navigate("/shopping-cart");
        assertTrue(shoppingCartPage.shoppingCartIsEmpty(), "Shopping cart is not empty!");
        assertFalse(shoppingCartPage.checkCheckoutButtonIsDisplayed(), "Checkout button is visible, but the shopping cart is empty!");
    }

    @Override
    protected void makePomInstances() {
        shoppingCartPage = new ShoppingCartPage(driver);
    }
}