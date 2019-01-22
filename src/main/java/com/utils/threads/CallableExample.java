package com.utils.threads;

import com.utils.dto.SmsDTO;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableExample implements Callable<Result> {
    private List<SmsDTO> items;
    private String name;
    private int number;
    private int totalThread;
    private int start;
    private int end;

    public CallableExample(String name, int number, int totalThread, List<SmsDTO> items) {
        this.name = name;
        this.number = number;
        this.totalThread = totalThread;
        this.items = items;
        //
        if (items != null && items.size() > 0) {
            initStartEnd();
        }
    }

    @Override
    public Result call() {
        //System.out.println("Thread " + name + " - " + number + " is running...");
        //System.out.println("Thread is currently processing item from: " + start + " to : " + end);
        int total = 0;
        String temp;
        for (int i = start; i <= end; i++) {
            temp = items.get(i - 1).getMsisdn();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Result(total);
    }

    private void initStartEnd() {

        int totalItem = items.size();
        int modArr = 0;
        if (number < totalThread - 1) {
            modArr = (int) (totalItem / totalThread);
            start = number * modArr + 1;
            end = number * modArr + modArr;
        } else {
            modArr = (int) (totalItem / totalThread) + totalItem % totalThread;
            start = totalItem - modArr + 1;
            end = totalItem;
        }
    }


}
