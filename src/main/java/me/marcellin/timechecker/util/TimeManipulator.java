package me.marcellin.timechecker.util;

import java.time.LocalTime;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @source https://stackoverflow.com/questions/25223553/how-can-i-create-an-utility-class
 */
public final class TimeManipulator {
    private TimeManipulator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param input String value to be converted into date ex: "9:30:12 AM"
     * @return {LocalDateTime} the today's date that has input time
     */
    public static LocalDateTime stringToTime(String input) {
        DateTimeFormatter formatter;
        LocalTime formatTime;
        try {
            formatter = DateTimeFormatter.ofPattern("h:mm a");
            formatTime = LocalTime.parse(input, formatter);
        } catch (Exception e1) {
            try {
                formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
                formatTime = LocalTime.parse(input, formatter);
            } catch (Exception e2) {
                try {
                    formatter = DateTimeFormatter.ofPattern("h:mm");
                    formatTime = LocalTime.parse(input, formatter);
                } catch (Exception e3) {
                    try {
                        formatter = DateTimeFormatter.ofPattern("h:mm:ss");
                        formatTime = LocalTime.parse(input, formatter);
                    } catch (Exception e4) {
                        try {
                            formatter = DateTimeFormatter.ofPattern("hh:mm a");
                            formatTime = LocalTime.parse(input, formatter);
                        } catch (Exception e5) {
                            try {
                                formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
                                formatTime = LocalTime.parse(input, formatter);
                            } catch (Exception e6) {
                                try {
                                    formatter = DateTimeFormatter.ofPattern("hh:mm");
                                    formatTime = LocalTime.parse(input, formatter);
                                } catch (Exception e7) {
                                    try {
                                        formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                                        formatTime = LocalTime.parse(input, formatter);
                                    } catch (Exception e8) {
                                        e6.printStackTrace();
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        LocalDateTime dateNow = LocalDateTime.now();

        try {
            // @TODO use remote logging system
            System.out.println("Before : " + dateNow.format(formatter));

            dateNow = dateNow.withHour(formatTime.getHour());
            dateNow = dateNow.withMinute(formatTime.getMinute());
            dateNow = dateNow.withSecond(formatTime.getSecond());

            System.out.println("After : " + dateNow.format(formatter));

        } catch (DateTimeException e) {
            e.printStackTrace();
        }
        return dateNow;
    }

}