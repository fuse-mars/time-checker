package me.marcellin.timechecker.util;

import me.marcellin.timechecker.util.OffsetSign;

public class UTCOffset {
    public String region;
    public OffsetSign sign;
    private int hours;
    public int getHours() {
        return this.sign == OffsetSign.PLUS? this.hours: 0 - this.hours;
    }
    private int minutes;
    public int getMinutes() {
        return this.sign == OffsetSign.PLUS? this.minutes: 0 - this.minutes;
    }
}