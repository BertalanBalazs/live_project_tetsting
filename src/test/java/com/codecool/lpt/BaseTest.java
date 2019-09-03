package com.codecool.lpt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

abstract class BaseTest {

    WebDriver driver;
    String nodeUrl;

    @BeforeEach
    void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        nodeUrl = "http://localhost:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        makePomInstances();
    }

    protected abstract void makePomInstances();

    @AfterEach
    void tearDown() {
        driver.close();
    }
}