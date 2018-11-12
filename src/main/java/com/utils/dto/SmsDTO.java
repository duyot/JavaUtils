package com.utils.dto;

public class SmsDTO {
    private String msisdn;
    private String telco;

    public SmsDTO(String msisdn, String telco) {
        this.msisdn = msisdn;
        this.telco = telco;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTelco() {
        return telco;
    }

    public void setTelco(String telco) {
        this.telco = telco;
    }

    @Override
    public String toString() {
        return "SmsDTO{" +
                "msisdn='" + msisdn + '\'' +
                ", telco='" + telco + '\'' +
                '}';
    }
}
