package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMultipleProductToShoppingCartTest extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void addMultipleProductToShoppingCart() {
        int result = mainPage.navigate()
                .clickOnFirstProductAddButton()
                .clickOnFirstProductAddButton()
                .clickOnShoppingCart()
                .getProductQuantityOfFirstProduct();

        assertEquals(2, result);
    }

    @AfterEach
    void clearShoppingCart(){
        shoppingCartPage.clearShoppingCart();
    }
}
