package com.codecool.lpt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

abstract class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        makePomInstances();
    }

    protected abstract void makePomInstances();

    @AfterEach
    void tearDown() {
        /*driver.close();*/
    }
}