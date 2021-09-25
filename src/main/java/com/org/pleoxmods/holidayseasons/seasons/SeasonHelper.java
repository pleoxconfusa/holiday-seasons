package com.org.pleoxmods.holidayseasons.seasons;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class SeasonHelper {
    public enum Seasons {
        EARLY_WINTER,
        MID_WINTER,
        LATE_WINTER,
        EARLY_SPRING,
        MID_SPRING,
        LATE_SPRING,
        EARLY_SUMMER,
        MID_SUMMER,
        LATE_SUMMER,
        EARLY_FALL,
        MID_FALL,
        LATE_FALL,
    }

    public Seasons getSeason(){
        // winter runs from december 21 to March 20, 89 days, thus 29 for early winter and 30 for mid and late
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();
        LocalDate fallEquinox = LocalDate.of(yearNow, Month.SEPTEMBER, 22);
        LocalDate winterSolstice = LocalDate.of(yearNow, Month.DECEMBER, 21);
        LocalDate springEquinox = LocalDate.of(yearNow, Month.MARCH, 20);
        LocalDate summerSolstice = LocalDate.of(yearNow, Month.JUNE, 21);

        if(now.isAfter(winterSolstice)
        && now.isBefore(winterSolstice.plusDays(29))){
            return Seasons.EARLY_WINTER;
        } else if(now.isAfter(winterSolstice.plusDays(29))
        && now.isBefore(winterSolstice.plusDays(59))){
            return Seasons.MID_WINTER;
        } else if(now.isAfter(winterSolstice.plusDays(89))
                && now.isBefore(winterSolstice.plusDays(119))){
            return Seasons.LATE_WINTER;
        } else if(now.isAfter(springEquinox)
                && now.isBefore(springEquinox.plusDays(30))){
            return Seasons.EARLY_SPRING;
        } else if(now.isAfter(springEquinox.plusDays(30))
                && now.isBefore(springEquinox.plusDays(61))){
            return Seasons.MID_SPRING;
        } else if(now.isAfter(springEquinox.plusDays(61))
                && now.isBefore(springEquinox.plusDays(92))){
            return Seasons.LATE_SPRING;
        } else if(now.isAfter(summerSolstice)
                && now.isBefore(summerSolstice.plusDays(31))){
            return Seasons.EARLY_SUMMER;
        } else if(now.isAfter(summerSolstice.plusDays(31))
                && now.isBefore(summerSolstice.plusDays(62))){
            return Seasons.MID_SUMMER;
        } else if(now.isAfter(summerSolstice.plusDays(62))
                && now.isBefore(summerSolstice.plusDays(93).plus(15, ChronoUnit.HOURS))){
            return Seasons.LATE_SUMMER;
        } else if(now.isAfter(fallEquinox)
                && now.isBefore(fallEquinox.plusDays(29))){
            return Seasons.EARLY_FALL;
        } else if(now.isAfter(fallEquinox.plusDays(29))
                && now.isBefore(fallEquinox.plusDays(59))){
            return Seasons.MID_FALL;
        } else if(now.isAfter(fallEquinox.plusDays(59))
                && now.isBefore(fallEquinox.plusDays(89).plus(20, ChronoUnit.HOURS))){
            return Seasons.LATE_FALL;
        }
        return null;
    }
}
