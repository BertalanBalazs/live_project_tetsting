package com.codecool.lpt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Initializer {
    @FindBy(id = "filterByCategory")
    WebElement filertByCategory;

    @FindBy(id = "filterBySupplier")
    WebElement filterBySupplier;

    @FindBy(xpath = "//input[@class='form-control mr-sm-2']")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-outline-success my-2 my-sm-0 bootstrap-button']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='btn btn-outline-success my-2 my-sm-0 bootstrap-button']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//a[5]")
    WebElement groupCategory;

    @FindBy(xpath = "//a[text()='Cartoon Network']")
    WebElement cartoonNetworkSupplier;

    @FindBy(xpath = "//a[text()='Dark\n" +
            "                            ']")
    WebElement darkTheme;

    @FindBy(xpath = "//a[text()='Light\n" +
            "                            ']")
    WebElement lightTheme;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeyToSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public void clickToSearchButton() {
        searchButton.click();
    }

    public boolean isElementDisplayedOnTheScreen(String elementName) {
        try {
            return driver.findElement(By.xpath("//*[text()='" + elementName + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}