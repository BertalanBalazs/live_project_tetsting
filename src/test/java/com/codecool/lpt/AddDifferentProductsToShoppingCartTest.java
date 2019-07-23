package com.codecool.lpt;

import com.codecool.lpt.pageObjects.CheckoutPage;
import com.codecool.lpt.pageObjects.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddDifferentProductsToShoppingCartTest extends BaseTest {
    private MainPage mainPage;
    private CheckoutPage checkoutPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }


    @Test
    void addOneProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnThirdProductAddButton();
        mainPage.clickOnShoppingCart();

        int resultFirst = checkoutPage.getProductQuantityOfFirstProduct();
        int resultSecond = checkoutPage.getProductQuantityOfSecondProduct();
        Assert.assertEquals(1, resultFirst);
        Assert.assertEquals(1, resultSecond);
    }
}
