package me.marcellin.timechecker.api.v1.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * We are modeling a time in a given city
 * so that is why we need variables for both time and city
 */
public class TimeModel {

    private LocalDateTime time;
    
    private String city;

    TimeModel(LocalDateTime time, String city) {
        this.time = time;
        this.city = city;
    }

    /**
     * time getter
     */
    @JsonIgnore
    public LocalDateTime getTime() {
        return this.time;
    }

    /**
     * time setter
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @JsonProperty(value= "time")
    public String getTimeString() {
        return this.toTimeString();
    }

    public String toTimeString() {
        String timeString = this.time.format(DateTimeFormatter.ofPattern("hh:mm a"));
        if (timeString.charAt(0) == '0') {
            timeString = timeString.substring(1, timeString.length());
        }
        return timeString;
    }

    // @Override
    // public String toString() {
    //     return String.format("{ city: %s, time: %s }", this.city, this.toTimeString());
    // }

}