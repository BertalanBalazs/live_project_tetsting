package com.codecool.lpt;

import com.codecool.lpt.pageObjects.CheckoutPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutWithoutProduct extends BaseTest {
    private CheckoutPage checkoutPage;

    @Override
    protected void makePomInstances() {
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void checkWithoutProduct(){
        checkoutPage.navigate("/shopping-cart");
        checkoutPage.clickOnCheckout();
        String currentUrl = checkoutPage.getCurrentPageUrl();
        assertEquals("localhost:8080/shopping-cart", currentUrl);
    }
}
