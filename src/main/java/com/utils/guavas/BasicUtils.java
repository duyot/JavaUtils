package com.utils.guavas;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class BasicUtils {
    public static void main(String[] args) {
        BasicUtils.checkPrecondition(5);
    }

    public static void checkPrecondition(int age){
        Preconditions.checkArgument(age >= 0, "Argument was %s but expected nonnegative", age);
        Preconditions.checkNotNull(age);
        System.out.println("OK");
    }
}
