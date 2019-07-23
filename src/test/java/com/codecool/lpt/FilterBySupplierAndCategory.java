package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;

public class FilterBySupplierAndCategory extends BaseTest {
    MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }
}
