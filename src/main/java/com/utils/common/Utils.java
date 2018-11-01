package com.utils.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Utils {


    public static String getPostRequestBody(HttpServletRequest request){
        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            return "";
        }
        Scanner s = null;
        try {
            s = new Scanner(request.getInputStream(), "UTF-8")
                    .useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        } catch (IOException e) {
            return s.hasNext() ? s.next() : "";
        }
    }

    public static <T>  void writeResponse(HttpServletResponse response, T object, boolean isJsonResponse){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (isJsonResponse) {
                out.println(JSONUtils.object2JSONString(object));
            }else{
                out.println(XMLUtils.objectToXMLString(object));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
    }

    public static boolean isStringNullOrEmpty(Object obj1) {
        return obj1 == null || obj1.toString().trim().equals("");
    }
}
