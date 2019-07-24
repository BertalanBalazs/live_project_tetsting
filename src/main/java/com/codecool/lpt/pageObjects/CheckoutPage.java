package com.codecool.lpt.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Initializer {
    @FindBy(xpath = "//tr[1]/td[2]")
    WebElement firstProductQuantity;

    @FindBy(xpath = "//tr[2]/td[2]")
    WebElement secondProductQuantity;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public int getProductQuantityOfFirstProduct() {
        return Integer.parseInt(firstProductQuantity.getText());
    }

    public int getProductQuantityOfSecondProduct() {
        return Integer.parseInt(secondProductQuantity.getText());
    }
}
