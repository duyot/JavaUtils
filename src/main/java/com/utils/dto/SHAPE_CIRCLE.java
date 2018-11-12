package com.utils.dto;

import java.util.List;

public class SHAPE_CIRCLE {
    public String SHAPE_TYPE;
    public List<SHAPE_CIRCLE_CENTER> SHAPE_CIRCLE_CENTER;

    public SHAPE_CIRCLE(String SHAPE_TYPE, List<SHAPE_CIRCLE_CENTER> SHAPE_CIRCLE_CENTER) {
        this.SHAPE_TYPE = SHAPE_TYPE;
        this.SHAPE_CIRCLE_CENTER = SHAPE_CIRCLE_CENTER;
    }

    public String getSHAPE_TYPE() {
        return SHAPE_TYPE;
    }

    public void setSHAPE_TYPE(String SHAPE_TYPE) {
        this.SHAPE_TYPE = SHAPE_TYPE;
    }

    public List<SHAPE_CIRCLE_CENTER> getSHAPE_CIRCLE_CENTER() {
        return SHAPE_CIRCLE_CENTER;
    }

    public void setSHAPE_CIRCLE_CENTER(List<SHAPE_CIRCLE_CENTER> SHAPE_CIRCLE_CENTER) {
        this.SHAPE_CIRCLE_CENTER = SHAPE_CIRCLE_CENTER;
    }
}
