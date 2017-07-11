package me.marcellin.timechecker.util;

import java.util.ArrayList;

public class UTCOffsetStore {
    // @TODO add getter and setters
    public ArrayList<UTCOffset> store;
    public UTCOffsetStore() {
        this.store = new ArrayList<UTCOffset>(5);
        this.fillStore();
    }

    public UTCOffset findUTCOffset(String city) {
        return this.store.stream()
        .filter(x -> city.equals(x.region))
        .findFirst()
        .orElse(null);
    }

    private void fillStore() {
        
        UTCOffset utcOffset = new UTCOffset();
        utcOffset.region = "New York";
        utcOffset.sign = OffsetSign.MINUS;
        utcOffset.setHours(4);
        utcOffset.setMinutes(0);
        this.store.add(utcOffset);


        utcOffset = new UTCOffset();
        utcOffset.region = "Kathmandu";
        utcOffset.sign = OffsetSign.PLUS;
        utcOffset.setHours(5);
        utcOffset.setMinutes(45);
        this.store.add(utcOffset);
    }
}