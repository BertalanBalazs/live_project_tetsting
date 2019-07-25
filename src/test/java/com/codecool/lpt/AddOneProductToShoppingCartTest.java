package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOneProductToShoppingCartTest extends BaseTest {
    MainPage mainPage;
    ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void addOneProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnShoppingCart();
        int result = shoppingCartPage.getProductQuantityOfFirstProduct();
        assertEquals(result, 1);
    }

    @AfterEach
    void clearShoppingCart(){
        shoppingCartPage.clearShoppingCart();
    }
}
