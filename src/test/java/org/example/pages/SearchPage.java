package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.example.tests.BaseTest.CONFIG;

public class SearchPage {
    public final By findOnMapButton = By.xpath("//button[@data-map-trigger-button='1']");
    public final By hotelCollection = By.xpath("//ul[@class='ced4498db9']");
    private final By rejectCookiesButton = By.xpath("//button[@id='onetrust-reject-all-handler']");
    private final By firstHotelPrice = By.xpath("//h2[@data-testid='header-title']");
    private final By pinPoint = By.xpath("//div[contains(@style, 'z-index: 101')]");
    //    private final By avgRate = By.xpath("")
    private final By firstCard = By.xpath("//a[@class='b6ae4fce06']");
    private final By dialogWindow = By.xpath("//div[contains(@role, 'dialog') and contains(@class, 'f0c216ee26 c676dd76fe b5018b639f')]");
    private final By dialogWindowCloseButton = By.xpath("//button[@aria-label='Dismiss sign in information.']");


    public SearchPage openSearchPage() {
        Selenide.open(CONFIG.searchUrl());
        return this;
    }

    public List<Object> getFirstInfoFromList() {
        List<Object> newList = new ArrayList<>();

        $(hotelCollection).shouldBe(Condition.visible, Duration.ofSeconds(3));

        SelenideElement firstElement = $$(hotelCollection).get(0);

        String hotelName = firstElement.getAttribute("h2");
        int avgRate = $$(By.xpath("//span[@data-testid='rating-squares']")).size();
        String hotelPrice = firstElement.getAttribute("span");

        newList.add(firstElement);
        newList.add(hotelName);
        newList.add(avgRate);
        newList.add(hotelPrice);
        return newList;
    }

    public SearchPage clickFindOnMapButton() {
        $(findOnMapButton).shouldBe(Condition.visible).click();
        return this;
    }

    public SearchPage rejectCookies() {
        $(rejectCookiesButton).shouldBe(Condition.visible).click();
        $(rejectCookiesButton).shouldNotBe(Condition.visible);
        return this;
    }

    public SearchPage rejectDialogWindow() {
        $(dialogWindow).shouldBe(Condition.visible, Duration.ofSeconds(3));
        $(dialogWindowCloseButton).click();
        return this;
    }

    public SearchPage hoverOverFirstHotel() {
        $(firstCard).hover();
        return this;
    }

    public SearchPage clickSelectedPinPoint() {
        $(pinPoint).click();
        return this;
    }
}
