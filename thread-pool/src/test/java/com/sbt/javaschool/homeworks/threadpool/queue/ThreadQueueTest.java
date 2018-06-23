package com.sbt.javaschool.homeworks.threadpool.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadQueueTest {
    private static ThreadQueue<Runnable> queue = new ThreadQueue();

    @Test
    public void put() {
        Task t = new Task(1);
        queue.put(t);
    }

    @Test
    public void get() {
        //queue.get();
        /*
        try {
            assertEquals("get()", Task.class, queue.get().getClass());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @Test
    public void getSize() {
        assertEquals("getSize()", 0, queue.getSize());
    }
}