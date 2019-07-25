package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AddDifferentMultipleProductsToShoppingCartTest extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void addDifferentMultipleProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnThirdProductAddButton();
        mainPage.clickOnThirdProductAddButton();
        mainPage.clickOnShoppingCart();

        int resultFirst = shoppingCartPage.getProductQuantityOfFirstProduct();
        int resultSecond = shoppingCartPage.getProductQuantityOfSecondProduct();
        Assert.assertEquals(2, resultFirst);
        Assert.assertEquals(2, resultSecond);
    }

    @AfterEach
    void clearShoppingCart(){
        shoppingCartPage.clearShoppingCart();
    }
}
