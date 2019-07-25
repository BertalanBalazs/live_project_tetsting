package com.codecool.lpt;

import com.codecool.lpt.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AutoAnswerTest extends BaseTest {
    MainPage mainPage;

    @Override
    protected void makePomInstances() {
        mainPage = new MainPage(driver);
    }

    @Test
    void autoAnswerCheck(){
        String result = mainPage.navigate()
                .clickOnCustomerService()
                .sendKeyToCustomerServiceInput("Mi van bumburnyák kaparsz? Azt hiszed te vagy a Miki?")
                .clickOnMessageSendButton()
                .customerServiceAnswererName();

        assertEquals("Chuck_Norris", result);
    }
}
