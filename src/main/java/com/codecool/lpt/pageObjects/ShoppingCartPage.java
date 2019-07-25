package com.codecool.lpt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends Initializer {
    @FindBy(xpath = "//tr[1]/td[2]")
    WebElement firstProductQuantity;

    @FindBy(xpath = "//tr[2]/td[2]")
    WebElement secondProductQuantity;

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
        int value = 1;
        int row = 0;
        int deletedProductsNum = 0;
        List<WebElement> initProducts = driver.findElements(By.xpath("//button[@class='btn btn-danger']"));
        while (true){
            int productQuantity = -1;
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tr["+row+"]/td[2]")));
                productQuantity = Integer.parseInt(driver.findElement(By.xpath("//tr["+row+"]/td[2]")).getText());
            } catch (Exception e) {
                row++;
            }

            try {
                WebElement productMinusButton = driver.findElement(By.xpath("//button[@class='btn btn-danger' and @value='" + value + "']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", productMinusButton);
                productMinusButton.click();
            } catch (Exception e) {
                value++;
            }

            List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-danger']"));
            if(products.size() == 0){
                break;
            }
            if((initProducts.size()-deletedProductsNum) > products.size()){
                deletedProductsNum++;
            }
            if (productQuantity == 0){
                value++;
            }

        }
    }
}
