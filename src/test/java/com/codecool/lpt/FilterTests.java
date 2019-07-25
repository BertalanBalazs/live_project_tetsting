package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilterTests extends BaseTest {
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

        List<String> excepted = new ArrayList<>();
        excepted.add("Dee Dee");
        excepted.add("Johnny Bravo");
        excepted.add("Mandark");
        excepted.add("Mojo Jojo");
        excepted.add("Powerpuff Girls");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }

    @Test
    void filterByCategory() {
        List<String> names = mainPage.navigate()
                .clickOnCategory()
                .clickOnGroupCategory()
                .getProductsName();

        List<String> excepted = new ArrayList<>();
        excepted.add("Inside Out");
        excepted.add("Powerpuff Girls");
        excepted.add("The Incredibles");
        excepted.add("Toy Story");

        assertArrayEquals(excepted.toArray(), names.toArray());
    }

    @Test
    void filterBySupplierAndCategory() {
        List<String> names = mainPage.navigate()
                .clickOnCategory()
                .clickOnGroupCategory()
                .clickOnSupplier()
                .clickOnCartoonSupplier()
                .getProductsName();

        List<String> excepted = new ArrayList<>();
        excepted.add("Powerpuff Girls");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }
}