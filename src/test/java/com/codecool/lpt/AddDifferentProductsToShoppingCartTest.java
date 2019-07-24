package com.codecool.lpt;

import com.codecool.lpt.pageObjects.CheckoutPage;
import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.Assert;
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
    void addOneProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnThirdProductAddButton();
        mainPage.clickOnShoppingCart();

        int resultFirst = shoppingCartPage.getProductQuantityOfFirstProduct();
        int resultSecond = shoppingCartPage.getProductQuantityOfSecondProduct();
        Assert.assertEquals(1, resultFirst);
        Assert.assertEquals(1, resultSecond);
    }
}
