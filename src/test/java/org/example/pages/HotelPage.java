package org.example.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class HotelPage {
    private final By hotelNameWindow = By.xpath("//h2[@class='d2fee87262 pp-header__title']");
    private final By hotelAvgRateWindow = By.xpath("//div[@data-testid='review-score-component']/div[1]");
    private final By hotelPriceWindow = By.xpath("//span[@class='prco-valign-middle-helper']");
    List<String> hotelValueListWindow = new ArrayList<>();

    public List<String> findValueListWindow() {
        String w1 = $(hotelNameWindow).shouldBe(Condition.visible).getText();
        String w2 = $(hotelAvgRateWindow).shouldBe(Condition.visible).scrollTo().getText();
        String w3 = $(hotelPriceWindow).shouldBe(Condition.visible).scrollTo().getText();
        hotelValueListWindow.add(w1);
        hotelValueListWindow.add(w2);
        hotelValueListWindow.add(w3);
        return hotelValueListWindow;
    }
}
