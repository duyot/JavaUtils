package com.utils.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunable {
    public static void main(String[] args) {
        ExecutorService poolexecutor = Executors
                .newFixedThreadPool(10);
        Runnable worker = new QueueConsumer();
        //
        poolexecutor.execute(worker);
    }
}
