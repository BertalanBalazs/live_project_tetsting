package com.codecool.lpt.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends Initializer {
    @FindBy(xpath = "//a[@class='submit-button btn btn-info']")
    WebElement checkoutButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", checkoutButton);
        checkoutButton.click();
    }
}
