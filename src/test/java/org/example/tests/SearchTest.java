package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.HotelPage;
import org.example.pages.SearchPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    HotelPage hotelPage = new HotelPage();
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
//                .rejectCookies()
                .clickFindOnMapButton();
        List<String> s1 = searchPage.getFirstInfoFromList();

        searchPage.hoverOverFirstHotel()
                .clickSelectedPinPoint();

        switchTo().window(1);

        List<String> s2 = hotelPage.findValueListWindow();

        assertEquals(s1.size(), s2.size());

        for (int i = 0; i < 2; i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
    }
}
