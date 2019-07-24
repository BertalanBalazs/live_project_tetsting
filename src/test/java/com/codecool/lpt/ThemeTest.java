package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

public class ThemeTest extends BaseTest {
    private MainPage mainPage;

    @Test
    void switchThemeToDark() throws InterruptedException {
        mainPage.navigate();
        mainPage.switchThemeToDark();
        Thread.sleep(10000);
    }

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }
}