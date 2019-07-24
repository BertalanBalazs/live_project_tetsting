package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMultipleProductToShoppingCartTest extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Test
    void addMultipleProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnShoppingCart();
        int result = shoppingCartPage.getProductQuantityOfFirstProduct();
        assertEquals(2, result);
    }

    @AfterEach
    void deleteComponent(){
        shoppingCartPage.clearShoppingCart();
    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }
}
