package me.marcellin.timechecker.api.v1.time;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/time")
public class TimeController {
 
    @Autowired
    private TimeService timeService;

    @RequestMapping("/{queryCity}")
    public TimeModel check(
        @PathVariable String queryCity, 
        @RequestParam(value="time", defaultValue="8:00 AM") String time,
                            @RequestParam(value="city", defaultValue="New York") String city) {
        
        return timeService.checkTimeByCity(queryCity, time, city);
        // => return TimeModel<{ time: computedTime, city: queryCity }>
    }
}