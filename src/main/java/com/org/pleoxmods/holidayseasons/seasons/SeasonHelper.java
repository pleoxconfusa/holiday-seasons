package com.org.pleoxmods.holidayseasons.seasons;

import net.minecraft.block.Block;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public List<Block> getSeasonalBlocks(){
            Seasons season = this.getSeason();
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(season.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            List<Class> blockClasses =  reader.lines()
                    .filter(line -> line.endsWith("Block.class"))
                    .map(line -> getClass(line, season.name()))
                    .collect(Collectors.toList());
            List<Block> seasonalBlocks = new ArrayList<>();
            for(Class clazz: blockClasses){
                try {
                    seasonalBlocks.add((Block)clazz.newInstance());
                } catch (Exception e) {
                    LOGGER.error("Error loading block class {}: {}", clazz.getName(), e.getMessage());
                }
            }
            return seasonalBlocks;
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error getting class name: {} in package: {} : {}", className, packageName, e.getMessage());
            return null;
        }
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
