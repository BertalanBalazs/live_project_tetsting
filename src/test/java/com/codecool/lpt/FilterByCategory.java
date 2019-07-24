package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

public class FilterByCategory extends BaseTest {
    MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void filterByCategory() {
        mainPage.navigate();
        mainPage.clickOnCategory();
        mainPage.clickOnGroupCategory();
    }
}
