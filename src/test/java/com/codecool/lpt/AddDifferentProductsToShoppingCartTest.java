package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AddDifferentProductsToShoppingCartTest extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void addDifferentProductToShoppingCart() {
        mainPage.navigate()
                .clickOnFirstProductAddButton()
                .clickOnThirdProductAddButton()
                .clickOnShoppingCart();

        int resultFirst = shoppingCartPage.getProductQuantityOfFirstProduct();
        int resultSecond = shoppingCartPage.getProductQuantityOfSecondProduct();
        Assert.assertEquals(1, resultFirst);
        Assert.assertEquals(1, resultSecond);
    }

    @AfterEach
    void clearShoppingCart() {
        shoppingCartPage.clearShoppingCart();
    }
}