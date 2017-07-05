package me.marcellin.timechecker.api.v1.time;

import org.springframework.stereotype.Service;

import me.marcellin.timechecker.util.TimeManipulator;
import me.marcellin.timechecker.util.UTCOffset;
import me.marcellin.timechecker.util.UTCOffsetStore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
        LocalDateTime dateTime = TimeManipulator.stringToTime(time);
        return this._checkTimeByCity(queryCity, new TimeModel(dateTime, city));
    }

    /**
     * we compute time in one city based the given time in another city
     * @param base TimeModel the base
     */
    public TimeModel _checkTimeByCity(String city, TimeModel base) {
        UTCOffset cityUTCOffset = this.utcOffsetStore.findUTCOffset(city);
        UTCOffset baseUTCOffset = this.utcOffsetStore.findUTCOffset(base.getCity());
        int hours = base.getTime().getHour() + cityUTCOffset.getHours() + baseUTCOffset.getHours();
        int minutes = base.getTime().getMinute() + cityUTCOffset.getMinutes() + baseUTCOffset.getMinutes();

        // @TODO will fails because stringToTime expects input of the format "h:mm:ss a"
        LocalDateTime dateTime = TimeManipulator.stringToTime(Integer.valueOf(hours).toString() + Integer.valueOf(minutes).toString()+":00");
        
        return new TimeModel(dateTime, city);
    }
}
