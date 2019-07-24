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


    public void clickOnFirstProductAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstProductAddButton);
        firstProductAddButton.click();
    }

    public void clickOnShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        shoppingCartButton.click();
    }


    public void clickOnThirdProductAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdProductAddButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", thirdProductAddButton);
        thirdProductAddButton.click();
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

    public void clickOnCategory() {
        //TODO double click need!
        filterByCategory.click();
        filterByCategory.click();
    }

    public void clickOnGroupCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(groupCategory));
        groupCategory.click();
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

    public void clickOnSupplier() {
        filterBySupplier.click();
        filterBySupplier.click();
    }

    public void clickOnCartoonSupplier() {
        wait.until(ExpectedConditions.elementToBeClickable(cartoonNetworkSupplier));
        cartoonNetworkSupplier.click();
    }

    public void clickOnThemeChanger() {
        themeChanger.click();
        themeChanger.click();
    }

    public void clickOnDarkTheme() {
        darkTheme.click();
    }


    public String getColorOfNavBar() {
        wait.until(ExpectedConditions.visibilityOf(navbar));
        return navbar.getCssValue("background-color");
    }

    public void clickOnLightTheme() {
        lightTheme.click();
    }
}