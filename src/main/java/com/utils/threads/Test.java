package com.utils.threads;

import com.utils.dto.SmsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static void testThread(List<SmsDTO> lst){
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(10);
        //
        Callable<Result> callable1 = new CallableExample("Thread 1", 0, 4, lst);
        Callable<Result> callable2 = new CallableExample("Thread 2", 1, 4, lst);
        Callable<Result> callable3 = new CallableExample("Thread 3", 2, 4, lst);
        Callable<Result> callable4 = new CallableExample("Thread 4", 3, 4, lst);
        //submit Callable tasks to be executed by thread pool
        Future<Result> future1 = es.submit(callable1);
        Future<Result> future2 = es.submit(callable2);
        Future<Result> future3 = es.submit(callable3);
        Future<Result> future4 = es.submit(callable4);
        //
        int total = 0;
        try {
            total = future1.get().getTotal() + future2.get().getTotal() + future3.get().getTotal() + future4.get().getTotal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //shut down the executor service now
        es.shutdown();
        //
        System.out.println("Result testThread is: " + total + " in: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void testNormal(List<SmsDTO> lst) {
        long start = System.currentTimeMillis();
        int total = 0;
        String temp;
        for (int i = 0; i < lst.size(); i++) {
            temp  = lst.get(i).getMsisdn();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result testNormal is: " + total + " in: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void main(String[] args) {
        //
        List<SmsDTO> lst = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            SmsDTO temp = new SmsDTO("" + i, "1");
            lst.add(temp);
        }
        //
        Test.testThread(lst);
        Test.testNormal(lst);

    }
}
