package me.marcellin.timechecker.api.v1.time;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Marcellin<mars@fusemachines.com>
 * @since 06-29-2017
 * 
 * @resource https://www.mkyong.com/java/how-to-convert-string-to-date-java/
 */
@Service
public class TimeService {

    TimeService() {
    }

/**
 * we compute time in one city based the given time in another city
 * @param base TimeModel the base
 */
    public TimeModel checkTimeByCity(String city, TimeModel base) {
        Date time = 
        return new TimeModel(time, city);
    }

    public UTCOffset findUTCOffset(String city) {
        
    }

    /**
     * @TODO put this inside a utililty package
     * @param input String value to be converted into date
     */
    public Date stringToDate(String input) {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        Date date = null;

        try {
            date = formatter.parse(input);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
