package org.example.utils;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DatePicker {
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDateTime NOW = LocalDateTime.now();
    private final YearMonth NOW_YM = YearMonth.now();

    public String todayDate() {
        return DTF.format(NOW);
    }

    public String someDaysAfterDate() {
        LocalDateTime someDays = NOW.plusDays(new Random()
                .nextInt(NOW_YM.lengthOfMonth() - NOW.getDayOfMonth()) + NOW.getDayOfMonth());
        return DTF.format(someDays);
    }
}
