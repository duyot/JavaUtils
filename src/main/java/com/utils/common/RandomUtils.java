package com.utils.common;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private RandomUtils(){
        throw new AssertionError();
    }

    public static int getRandomInt(){
        return ThreadLocalRandom.current().nextInt();
    }

    public static int getRandomIntInRange(int start, int end){
        return ThreadLocalRandom.current().nextInt(start,end);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.getRandomInt());
        }
    }
}
