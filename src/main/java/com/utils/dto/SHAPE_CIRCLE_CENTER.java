package com.utils.dto;

public class SHAPE_CIRCLE_CENTER {
    public String LAT;
    public String LONG;

    public SHAPE_CIRCLE_CENTER(String LAT, String LONG) {
        this.LAT = LAT;
        this.LONG = LONG;
    }

    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public String getLONG() {
        return LONG;
    }

    public void setLONG(String LONG) {
        this.LONG = LONG;
    }
}
