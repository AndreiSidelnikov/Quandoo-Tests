package com.telran.quandoo.pages;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.telran.quandoo.pages.CommonsPage.BASE_URL;


public class BerlinPage {

    /* Elements */

    private static By topRatedBtn = By.xpath("//button[@data-qa='filter-button-top-rated']");
    private static By reviewScore = By.xpath("//*[@id='tab-merchants']/div[2]/div[1]/div[2]/div[2]/div/div/div");
    private static By africanCuisineFilter = By.xpath("//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00']");
    private static By africanCuisineFilterNumber = By.xpath("//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00']/span[2]");
    private static By merchantCards = By.xpath("//div[@data-qa='merchant-card-wrapper']");
    private static By resultsCount = By.xpath("//div[@data-qa='results-count']");
    private static By firstMerchCard = By.xpath("//div[@data-qa='merchant-card-wrapper'][1]");


    /* Methods */

    public BerlinPage openPage(){
        open(BASE_URL + "en/berlin");
        getWebDriver().manage().window().maximize();
        return page(BerlinPage.class);
    }

    public void clickOnTopRated() {
        $(topRatedBtn).click();
    }

    public SelenideElement firstRestaurantCard(){
        return $(firstMerchCard);
    }

    public int getFirstRestaurantRating(){
        String score = $(reviewScore).getText().split("\\.")[0];
        return Integer.parseInt(score);
    }

    public SelenideElement restaurantCount() {
        return $(resultsCount); }

    public void selectAfricanCuisineFilter() {
        $(africanCuisineFilter).click();
    }

    public int getAfricanRestaurantCount() {
        String str = $(africanCuisineFilterNumber).getText();
        int count = Integer.parseInt(str.substring(1, str.length() - 1));
        return count;
    }

    public int getRestaurantListSize() {
        return $$(merchantCards).size();
    }
}