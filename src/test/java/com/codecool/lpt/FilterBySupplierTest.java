package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilterBySupplierTest extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void filterBySupplier() {
        List<String> names = mainPage.navigate()
                .clickOnSupplier()
                .clickOnSupplier()
                .clickOnCartoonSupplier()
                .getProductsName();

        List<String> excepted = new ArrayList<String>();
        excepted.add("Dee Dee");
        excepted.add("Johnny Bravo");
        excepted.add("Mandark");
        excepted.add("Mojo Jojo");
        excepted.add("Powerpuff Girls");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }
}