package me.marcellin.timechecker.api.v1.time;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/time")
public class TimeController {
 
    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/{queryCity}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<TimeModel> check(
        @PathVariable String queryCity, 
        @RequestParam(value="time", defaultValue="8:00 AM") String time,
                            @RequestParam(value="city", defaultValue="New York") String city) {
        
        TimeModel timeModel = timeService.checkTimeByCity(queryCity, time, city);
        return new ResponseEntity<>(timeModel, HttpStatus.OK);
        // return TimeModel<{ time: computedTime, city: queryCity }>
    }
}