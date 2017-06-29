package me.marcellin.timechecker.api.v1.time;

import org.springframework.stereotype.Service;

import me.marcellin.timechecker.util.UTCOffset;
import me.marcellin.timechecker.util.UTCOffsetStore;

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
    private UTCOffsetStore utcOffsetStore;

    TimeService() {
        this.utcOffsetStore = new UTCOffsetStore();
    }

    public TimeModel checkTimeByCity(String queryCity, String time, String city) {
        Date dateTime = this.stringToDate(time);
        return this._checkTimeByCity(queryCity, new TimeModel(dateTime, city));
    }

    /**
     * we compute time in one city based the given time in another city
     * @param base TimeModel the base
     */
    public TimeModel _checkTimeByCity(String city, TimeModel base) {
        UTCOffset cityUTCOffset = this.utcOffsetStore.findUTCOffset(city);
        UTCOffset baseUTCOffset = this.utcOffsetStore.findUTCOffset(base.getCity());
        int hours = base.getTime().getHours() + cityUTCOffset.getHours() + baseUTCOffset.getHours();
        int minutes = base.getTime().getMinutes() + cityUTCOffset.getMinutes() + baseUTCOffset.getMinutes();

        Date dateTime = this.stringToDate(Integer.valueOf(hours).toString() + Integer.valueOf(minutes).toString());
        return new TimeModel(dateTime, city);
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
