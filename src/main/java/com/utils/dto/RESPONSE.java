package com.utils.dto;

public class RESPONSE {
    public String ERROR_CODE;
    public String ERROR_DESC;
    public String TOTAL_SUBS;
    public String TOTAL_SUBS_EXCLUDE_REFUSE;

    public RESPONSE(String ERROR_CODE, String ERROR_DESC, String TOTAL_SUBS, String TOTAL_SUBS_EXCLUDE_REFUSE) {
        this.ERROR_CODE = ERROR_CODE;
        this.ERROR_DESC = ERROR_DESC;
        this.TOTAL_SUBS = TOTAL_SUBS;
        this.TOTAL_SUBS_EXCLUDE_REFUSE = TOTAL_SUBS_EXCLUDE_REFUSE;
    }

    public String getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(String ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public String getERROR_DESC() {
        return ERROR_DESC;
    }

    public void setERROR_DESC(String ERROR_DESC) {
        this.ERROR_DESC = ERROR_DESC;
    }

    public String getTOTAL_SUBS() {
        return TOTAL_SUBS;
    }

    public void setTOTAL_SUBS(String TOTAL_SUBS) {
        this.TOTAL_SUBS = TOTAL_SUBS;
    }

    public String getTOTAL_SUBS_EXCLUDE_REFUSE() {
        return TOTAL_SUBS_EXCLUDE_REFUSE;
    }

    public void setTOTAL_SUBS_EXCLUDE_REFUSE(String TOTAL_SUBS_EXCLUDE_REFUSE) {
        this.TOTAL_SUBS_EXCLUDE_REFUSE = TOTAL_SUBS_EXCLUDE_REFUSE;
    }
}
