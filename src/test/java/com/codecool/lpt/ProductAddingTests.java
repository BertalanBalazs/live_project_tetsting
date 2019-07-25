package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductAddingTests extends BaseTest {
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void addOneProductToShoppingCart() {
        int result = mainPage.navigate()
                .clickOnFirstProductAddButton()
                .clickOnShoppingCart()
                .getProductQuantityOfFirstProduct();

        assertEquals(result, 1);
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

    @Test
    void addDifferentMultipleProductToShoppingCart() {
        mainPage.navigate().clickOnFirstProductAddButton()
                .clickOnFirstProductAddButton()
                .clickOnThirdProductAddButton()
                .clickOnThirdProductAddButton()
                .clickOnShoppingCart();

        int resultFirst = shoppingCartPage.getProductQuantityOfFirstProduct();
        int resultSecond = shoppingCartPage.getProductQuantityOfSecondProduct();
        Assert.assertEquals(2, resultFirst);
        Assert.assertEquals(2, resultSecond);
    }

    @AfterEach
    void clearShoppingCart() {
        shoppingCartPage.clearShoppingCart();
    }
}