package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ShoppingCartPageTests extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
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

    @Test
    void tryToCheckOutWithoutAnyItemInTheShoppingCart() {
        shoppingCartPage.navigateToShoppingCartPage()
                .clearShoppingCart();

        assertFalse(shoppingCartPage.checkCheckoutButtonIsDisplayed(), "Checkout button is visible, but the shopping cart is empty!");
    }

    @Test
    void checkTotalPriceIsShownTheCorrespondingValue() {
        String expectedValue = "990";
        String expectedValueString = "Total price: " + expectedValue + ".0 USD";

        shoppingCartPage.navigateToShoppingCartPage().clearShoppingCart();

        mainPage.navigate().clickOnFirstProductAddButton()
                .clickOnFirstProductAddButton()
                .clickOnThirdProductAddButton()
                .clickOnThirdProductAddButton()
                .clickOnShoppingCart();

        assertEquals(expectedValueString, shoppingCartPage.totalPrice());
    }
}