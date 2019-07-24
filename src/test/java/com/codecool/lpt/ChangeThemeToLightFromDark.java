package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChangeThemeToLightFromDark extends BaseTest {
    private MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void changeThemeToDark(){
        mainPage.navigate();
        mainPage.clickOnThemeChanger();
        mainPage.clickOnDarkTheme();
        String darkThemeColor = mainPage.getColorOfNavBar();

        mainPage.clickOnThemeChanger();
        mainPage.clickOnLightTheme();
        String lightThemeColor = mainPage.getColorOfNavBar();

        assertNotEquals(lightThemeColor, darkThemeColor);
    }
}
