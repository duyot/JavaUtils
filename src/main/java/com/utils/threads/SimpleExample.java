package com.utils.threads;

import com.utils.dto.SmsDTO;

import java.util.ArrayList;
import java.util.List;

/*
    start 1
    end n
 */
class ListProcessThread extends Thread {
    private String name;
    private int number;
    private int totalThread;
    private List<SmsDTO> items;
    private int start;
    private int end;
    private Thread t;

    public ListProcessThread(String name, int number, int totalThread, List<SmsDTO> items) {
        this.name = name;
        this.number = number;
        this.totalThread = totalThread;
        this.items = items;
        //
        if (items != null && items.size() > 0) {
            initStartEnd();
        }
    }

    public static void main(String[] args) {
        List<SmsDTO> lst = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            SmsDTO temp = new SmsDTO("" + i, "1");
            lst.add(temp);
        }
        System.out.println(lst.size());
        //
        ListProcessThread thread1 = new ListProcessThread("Thread 1", 0, 2, lst);
        ListProcessThread thread2 = new ListProcessThread("Thread 2", 1, 2, lst);
        thread1.start();
        thread2.start();
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

    public void run() {
        System.out.println("Thread " + name + " - " + number + " is running...");
        System.out.println("Thread is currently processing item from: " + start + " to : " + end);
        for (int i = start; i <= end; i++) {
            System.out.println(items.get(i - 1).toString());
        }

    }

    public void start() {
        System.out.println("Starting " + name);
        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }

    private List<SmsDTO> initListTest() {
        List<SmsDTO> lst = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            SmsDTO temp = new SmsDTO("" + i, "1");
            lst.add(temp);
        }
        //
        return lst;
    }
}
