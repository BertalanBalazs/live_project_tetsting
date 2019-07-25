package com.codecool.lpt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends Initializer {
    @FindBy(id = "filterByCategory")
    WebElement filterByCategory;

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

    @FindBy(xpath = "//button[@value='1']")
    WebElement firstProductAddButton;

    @FindBy(xpath = "//button[@value='3']")
    WebElement thirdProductAddButton;

    @FindBy(xpath = "//button[@id='theme']")
    WebElement themeChanger;

    @FindBy(xpath = "//nav[@id='index_navbar']")
    WebElement navbar;


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage clickOnFirstProductAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstProductAddButton);
        firstProductAddButton.click();
        return this;
    }

    public ShoppingCartPage clickOnShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }


    public MainPage clickOnThirdProductAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdProductAddButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", thirdProductAddButton);
        thirdProductAddButton.click();
        return this;
    }

    public MainPage sendKeyToSearchInput(String text) {
        searchInput.sendKeys(text);
        return this;
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

    public MainPage clickOnCategory() {
        filterByCategory.click();
        filterByCategory.click();
        return this;
    }

    public MainPage clickOnGroupCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(groupCategory));
        groupCategory.click();
        return this;
    }

    public List<String> getProductsName() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h4[@class='card-title']"))));
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
        List<String> names = new ArrayList<String>();
        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }

    public MainPage clickOnSupplier() {
        filterBySupplier.click();
        filterBySupplier.click();
        return this;
    }

    public MainPage clickOnCartoonSupplier() {
        wait.until(ExpectedConditions.elementToBeClickable(cartoonNetworkSupplier));
        cartoonNetworkSupplier.click();
        return this;
    }


    public MainPage clickOnThemeChanger() {
        themeChanger.click();
        themeChanger.click();
        return this;
    }

    public MainPage clickOnDarkTheme() {
        darkTheme.click();
        return this;
    }


    public String getColorOfNavBar() {
        wait.until(ExpectedConditions.visibilityOf(navbar));
        return navbar.getCssValue("background-color");
    }

    public MainPage clickOnLightTheme() {
        lightTheme.click();
        return this;
    }
}