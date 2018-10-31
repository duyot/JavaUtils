package com.utils.common;

import com.google.gson.Gson;
import com.smsmkt.dto.GetSmsStatusRequestDTO;
import com.smsmkt.dto.RQST;

/**
 * Created by duyot on 7/7/2016.
 */
public class JSONUtils {
    public static Gson gson = new Gson();

    public static String object2JSONString(Object object){
        return gson.toJson(object);
    }

    public static  <T> T stringToObject(String jsonString,Class objectClass){
        return (T)gson.fromJson(jsonString,objectClass);
    }

    public static void main(String[] args) {
        RQST a = new RQST();
        a.setName("abc");
        a.setMSISDN("abc");
        System.out.println(JSONUtils.object2JSONString(new GetSmsStatusRequestDTO(a)));
    }

}
