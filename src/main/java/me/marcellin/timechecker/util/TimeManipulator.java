package me.marcellin.timechecker.util;

import java.time.LocalTime;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @source https://stackoverflow.com/questions/25223553/how-can-i-create-an-utility-class
 */
public final class TimeManipulator {

    /**
     * @param input String value to be converted into date ex: "9:30:12 AM"
     * @return {LocalDateTime} the today's date that has input time
     */
    public static LocalDateTime stringToTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss a");

        LocalDateTime dateNow = LocalDateTime.now();

        try {
            // @TODO use remote logging system
            System.out.println("Before : " + dateNow.format(formatter));

            LocalTime formatTime = LocalTime.parse(input, formatter);

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