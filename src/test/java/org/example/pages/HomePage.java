package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.example.utils.DatePicker;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.example.tests.BaseTest.CONFIG;

public class HomePage {

    private final By searchInputCity = By.xpath("//input[@class='eb46370fe1']");
    private final By dateContainer = By.xpath("//div[@class='a1139161bf']");
    private final By datePicker = By.xpath("//div[@data-testid='searchbox-datepicker-calendar']");
    private final By dateBegin = By.xpath(String.format("//span[@data-date='%s']", new DatePicker().todayDate()));
    private final By dateEnd = By.xpath(String.format("//span[@data-date='%s']", new DatePicker().someDaysAfterDate()));
    private final By findButton = By.xpath("//div[@class='e22b782521 d12ff5f5bf']");
    private final By searchFirstResult = By.xpath("//li[@id='autocomplete-result-0']");
    private final By rejectCookiesButton = By.xpath("//button[@id='onetrust-reject-all-handler']");
    private final By dialogWindow = By.xpath("//div[@role='dialog']");
    private final By dialogWindowCloseButton = By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']");

    public HomePage openHomePage() {
        Selenide.open(CONFIG.baseUrl());
        return this;
    }

    public HomePage fillSearchByCity(String cityName) {
        $(searchInputCity).sendKeys(cityName);
        $(searchFirstResult).shouldBe(Condition.visible).shouldHave(Condition.text(cityName)).click();
        return this;
    }

    public HomePage pickRandomDates() {
        $(datePicker).shouldBe(Condition.visible);
        $(dateBegin).click();
        $(dateEnd).click();
        return this;
    }

    public HomePage clickFindButton() {
        $(findButton).click();
        return this;
    }

    public HomePage rejectCookies() {
        $(rejectCookiesButton).shouldBe(Condition.visible).click();
        $(rejectCookiesButton).shouldNotBe(Condition.visible);
        return this;
    }

    public HomePage rejectDialogWindow() {
        $(dialogWindow).shouldBe(Condition.visible, Duration.ofSeconds(3));
        $(dialogWindowCloseButton).click();
        return this;
    }
}
