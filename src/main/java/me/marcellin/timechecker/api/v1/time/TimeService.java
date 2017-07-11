package me.marcellin.timechecker.api.v1.time;

import org.springframework.stereotype.Service;

import me.marcellin.timechecker.util.TimeManipulator;
import me.marcellin.timechecker.util.UTCOffset;
import me.marcellin.timechecker.util.UTCOffsetStore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private TimeModel _checkTimeByCity(String city, TimeModel base) {
        UTCOffset cityUTCOffset = this.utcOffsetStore.findUTCOffset(city);
        UTCOffset baseUTCOffset = this.utcOffsetStore.findUTCOffset(base.getCity());
        // remove to get to UTC, then add to get to desired city
        int hours = base.getTime().getHour() - baseUTCOffset.getHours() + cityUTCOffset.getHours();
        int minutes = base.getTime().getMinute() - baseUTCOffset.getMinutes() + cityUTCOffset.getMinutes();

		System.err.printf("[base] %d %d\n", baseUTCOffset.getHours(), baseUTCOffset.getMinutes());
		System.err.printf("[city] %d %d\n", cityUTCOffset.getHours(), cityUTCOffset.getMinutes());

        // @TODO will fails because stringToTime expects input of the format "h:mm:ss a"
        LocalDateTime dateTime = LocalDateTime.now();
        
        dateTime = dateTime.withHour(0);
        dateTime = dateTime.withMinute(0);
        
        dateTime = dateTime.plusHours(hours);
        dateTime = dateTime.plusMinutes(minutes);

        return new TimeModel(dateTime, city);
    }
}
