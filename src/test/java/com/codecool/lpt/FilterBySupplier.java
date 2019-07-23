package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;

public class FilterBySupplier extends BaseTest {
    MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }
}
