package com.codecool.lpt;

import com.codecool.lpt.pageObjects.CheckoutPage;
import com.codecool.lpt.pageObjects.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddOneProductToShoppingCartTest extends BaseTest {
    MainPage mainPage;
    CheckoutPage checkoutPage;

    @Test
    void addOneProductToShoppingCart() {
        mainPage.navigate();
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnShoppingCart();
        int result = checkoutPage.getProductQuantityOfFirstProduct();
        Assert.assertEquals(result, 1);
    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
