package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChangeThemeToDarkTest extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void changeThemeToDark() {
        String lightThemeColor = mainPage.navigate()
                .getColorOfNavBar();

        String darkThemeColor = mainPage.clickOnThemeChanger()
                .clickOnDarkTheme()
                .getColorOfNavBar();

        assertNotEquals(lightThemeColor, darkThemeColor);
    }
}