package me.marcellin.timechecker.api.v1.time;

import java.time.LocalDateTime;

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

}