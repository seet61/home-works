package com.sbt.javaschool.homeworks.threadpool.queue;

public class Task implements Runnable{
    private int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " task " + num + " is running");
    }
}
