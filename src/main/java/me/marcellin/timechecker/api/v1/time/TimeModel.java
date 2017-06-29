package me.marcellin.timechecker.api.v1.time;

import java.util.Date;

/**
 * We are modeling a time in a given city
 * so that is why we need variables for both time and city
 */
public class TimeModel {

    public Date time;
    public String city;

    TimeModel(Date time, String city) {
        this.time = time;
        this.city = city;
    }
    
    /**
     * time getter
     */
    public Date getTime() {
        return this.time;
    }
    /**
     * time setter
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}