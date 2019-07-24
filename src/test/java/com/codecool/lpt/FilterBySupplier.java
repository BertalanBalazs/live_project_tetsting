package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilterBySupplier extends BaseTest {
    MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void filterByCategory() {
        mainPage.navigate();
        mainPage.clickOnSupplier();
        mainPage.clickOnCartoonSupplier();
        List<String> names = mainPage.getProductsName();
        List<String> excepted = new ArrayList<String>();
        excepted.add("Dee Dee");
        excepted.add("Johnny Bravo");
        excepted.add("Mandark");
        excepted.add("Mojo Jojo");
        excepted.add("Powerpuff Girls");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }
}
