package com.utils.dto;

public class LBARequest {
    public String NAME;
    public String REQID;
    public SHAPE_CIRCLE SHAPE_CIRCLE;

    public LBARequest(String NAME, String REQID, com.utils.dto.SHAPE_CIRCLE SHAPE_CIRCLE) {
        this.NAME = NAME;
        this.REQID = REQID;
        this.SHAPE_CIRCLE = SHAPE_CIRCLE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getREQID() {
        return REQID;
    }

    public void setREQID(String REQID) {
        this.REQID = REQID;
    }

    public com.utils.dto.SHAPE_CIRCLE getSHAPE_CIRCLE() {
        return SHAPE_CIRCLE;
    }

    public void setSHAPE_CIRCLE(com.utils.dto.SHAPE_CIRCLE SHAPE_CIRCLE) {
        this.SHAPE_CIRCLE = SHAPE_CIRCLE;
    }
}
