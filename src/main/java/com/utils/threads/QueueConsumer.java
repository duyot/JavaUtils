package com.utils.threads;

public class QueueConsumer implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
