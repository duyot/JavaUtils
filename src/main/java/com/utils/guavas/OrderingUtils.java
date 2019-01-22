package com.utils.guavas;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public class OrderingUtils {
    public static Ordering<String> initOrderByLength(){
        return new Ordering<String>() {
            @Override
            public int compare(@Nullable String s, @Nullable String t1) {
                return Ints.compare(s.length(),t1.length());
            }
        };
    }

    public static Ordering<String> initOrderByType() {
        return Ordering.natural().nullsFirst().onResultOf(s -> s.length());
    }

    public static void main(String[] args) {
        List<String> users1 = Lists.newArrayList();
        users1.add("a");
        users1.add("def");
        users1.add("bc");
        //
        List<String> users2 = Lists.newArrayList();
        users2.add("a");
        users2.add("def");
        users2.add("bc");
        //
        users1.sort(OrderingUtils.initOrderByLength().reversed());
        users1.sort(OrderingUtils.initOrderByLength().nullsFirst());
        List<String> top1 =  OrderingUtils.initOrderByLength().greatestOf(users1,1);
        List<String> top2 =  OrderingUtils.initOrderByLength().leastOf(users1,1);
        String test = OrderingUtils.initOrderByLength().min("34","34342");
        System.out.println(test);
        //
        for(String i: top2){
            System.out.println(i);
        }
    }
}
