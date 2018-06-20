package com.sbt.javaschool.homeworks.threadpool.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThreadQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public synchronized void put(T task) {
        this.queue.add(task);
        this.notifyAll();
    }

    public synchronized <T> T get() throws InterruptedException {
        if (queue.size() == 0) {
            this.wait();
        }
        T el = (T) queue.element();
        queue.remove(el);
        return el;
    }

    public synchronized int getSize() {
        return queue.size();
    }
}
