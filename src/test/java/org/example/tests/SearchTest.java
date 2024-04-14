package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.SearchPage;
import org.junit.Test;

public class SearchTest extends BaseTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    public final String CITY_NAME = "Сеул";

    @Test
    public void testSearch() {
        homePage.openHomePage()
////                .rejectDialogWindow()
                .rejectCookies()
                .fillSearchByCity(CITY_NAME)
                .pickRandomDates()
                .clickFindButton();

        searchPage
                .rejectDialogWindow()
                .clickFindOnMapButton()
                .hoverOverFirstHotel()
                .clickSelectedPinPoint();
//                .getFirstInfoFromList();
    }
}
