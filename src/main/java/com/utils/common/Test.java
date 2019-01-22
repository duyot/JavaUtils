package com.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Test{

    private static final Pattern PATTERN  = Pattern.compile("abcd");
    private static Logger log = LoggerFactory.getLogger(Test.class);

    public static boolean isValidString(String s){
        return s.matches("abcd");
    }

    public static boolean isValidString(String s, Pattern pattern){
        return pattern.matcher(s).matches();
    }

    public static long sumAllIntV1(){
        Long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sumAllIntV2(){
        long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }



    public static void main(String[] args) {
        log.info("Start test sumAllIntV1");
        log.info("Sum is: "+ Test.sumAllIntV1());
        log.info("Start test sumAllIntV2");
        log.info("Sum is: "+ Test.sumAllIntV2());
        log.info("End");
    }
}
