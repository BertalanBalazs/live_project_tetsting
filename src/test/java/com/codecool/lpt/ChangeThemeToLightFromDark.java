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
        String darkThemeColor = mainPage.navigate()
                .clickOnThemeChanger()
                .clickOnDarkTheme()
                .getColorOfNavBar();

        String lightThemeColor = mainPage.clickOnThemeChanger()
                .clickOnLightTheme()
                .getColorOfNavBar();

        assertNotEquals(lightThemeColor, darkThemeColor);
    }
}
