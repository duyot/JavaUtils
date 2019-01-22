package com.utils.guavas;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

public class GuavaStringUtils {

    public static String join(List<Integer> items){
        return Joiner.on(",").join(items);
    }

    public static List<String> split(String s){
        return Splitter.on(",").trimResults().omitEmptyStrings().splitToList(s);
    }

    public static void main(String[] args) {
        List<Integer> ids = Lists.newArrayList();
        System.out.println(GuavaStringUtils.split("3,4,5,3,2,,5").size());
    }
}
