package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        List<String> names = mainPage.getProductsName();
        List<String> excepted = new ArrayList<String>();
        excepted.add("Inside Out");
        excepted.add("Powerpuff Girls");
        excepted.add("The Incredibles");
        excepted.add("Toy Story");
        assertArrayEquals(excepted.toArray(), names.toArray());
    }
}
