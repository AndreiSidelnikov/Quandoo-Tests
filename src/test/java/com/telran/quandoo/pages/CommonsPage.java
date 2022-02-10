package com.telran.quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CommonsPage {

    public static final String BASE_URL = "https://www.quandoo.de/";

    /** Elements **/
    private static By accCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    /** Methods **/

    public void acceptAllCookies() {
        if ($(accCookies).exists()){
            $(accCookies).click();
        }
    }
}
