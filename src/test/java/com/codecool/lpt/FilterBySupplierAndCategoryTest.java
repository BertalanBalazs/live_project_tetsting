package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilterBySupplierAndCategoryTest extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void filterBySupplierAndCategory() {
        List<String> names = mainPage.navigate()
                .clickOnCategory()
                .clickOnGroupCategory()
                .clickOnSupplier()
                .clickOnCartoonSupplier()
                .getProductsName();

        List<String> excepted = new ArrayList<String>();
        excepted.add("Powerpuff Girls");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }
}