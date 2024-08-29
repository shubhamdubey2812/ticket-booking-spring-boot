package com.js.ticket_booking_spring_boot.utils;

import java.time.Duration;
import java.time.LocalTime;

public class CalculationTrainDuration {

    public static String calculateDuration(LocalTime departure, LocalTime arrival) {
        Duration duration = Duration.between(departure, arrival);

        // If arrival time is before departure time, it means the train arrives the next day
        if (duration.isNegative()) {
            duration = duration.plusDays(1);
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return hours + "h:" + minutes + "m";
    }


    }

