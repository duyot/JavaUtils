package com.utils.threads;

public class LockObject {

    private static Object lock_obj = new Object();

    public static int synLog(){
        synchronized (lock_obj){
            return -1;
        }
    }
}
