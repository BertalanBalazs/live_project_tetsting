package com.codecool.lpt.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Initializer {
    @FindBy(xpath = "//tr[1]/td[2]")
    WebElement firstProductQuantity;

    @FindBy(xpath = "//tr[2]/td[2]")
    WebElement secondProductQuantity;

    @FindBy(xpath = "//*[@class='btn btn-outline-success my-2 my-sm-0 bootstrap-button']")
    WebElement backToHomePageButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getProductQuantityOfFirstProduct() {
        return Integer.parseInt(firstProductQuantity.getText());
    }

    public int getProductQuantityOfSecondProduct() {
        return Integer.parseInt(secondProductQuantity.getText());
    }

    public void clearShoppingCart() {

    }

    public void clickBackToHomePageButton() {
        backToHomePageButton.click();
    }
}
