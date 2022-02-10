package com.telran.quandoo.tests;

import com.codeborne.selenide.Condition;
import com.telran.quandoo.pages.BerlinPage;
import com.telran.quandoo.pages.CommonsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * UI test for search filter https://www.quandoo.de/en/berlin
 */
public class FilterTests {
    BerlinPage restBerlinPage;

    @BeforeEach
    public void setUp() {
        //open  Restaurants in Berlin page
        restBerlinPage = new BerlinPage().openPage();
        //accept cookies
        new CommonsPage().acceptAllCookies();
    }

    @Test
    /**
     * Test:
     * click filter Top rated;
     * check number of displayed restaurants
     * select African filter in Cuisine filter;
     * check number of displayed restaurants
     */
    public void topRatedAfricanFilterTest() {
        //save total restaurants number to variable
        String restCountBefore = restBerlinPage.restaurantCount().getText();
        //click filter Top rated
        restBerlinPage.clickOnTopRated();
        // assert that the rating of the first restaurant is more than 4
        assertTrue(restBerlinPage.getFirstRestaurantRating() >= 4);
        //assert total number of restaurants changed
        restBerlinPage.restaurantCount().shouldNotHave(exactValue(restCountBefore));
        // click on African Filter in Cuisine filter
        restBerlinPage.selectAfricanCuisineFilter();
        // assert that the first restaurant has African cuisine label
        restBerlinPage.firstRestaurantCard().shouldHave(text("African"));
        //assert correct number of displayed restaurants
        assertEquals(restBerlinPage.getAfricanRestaurantCount(), restBerlinPage.getRestaurantListSize());
    }
}