package com.codecool.lpt.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Initializer {

    final WebDriver driver;
    final WebDriverWait wait;

    Initializer(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    public void navigate(String subUrl) {
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    public void navigate() {
        driver.navigate().to(System.getenv("baseUrl"));
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }
}
