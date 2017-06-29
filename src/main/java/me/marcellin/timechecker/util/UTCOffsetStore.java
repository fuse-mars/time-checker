package me.marcellin.timechecker.util;

import java.util.ArrayList;

public class UTCOffsetStore {
    // @TODO add getter and setters
    public ArrayList<UTCOffset> store;
    public UTCOffsetStore() {
        this.store = new ArrayList<UTCOffset>(5);
    }

    public UTCOffset findUTCOffset(String city) {
        return this.store.get(1);
    }
}