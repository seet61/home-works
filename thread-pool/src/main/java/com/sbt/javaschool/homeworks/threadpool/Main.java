package com.sbt.javaschool.homeworks.threadpool;

import com.sbt.javaschool.homeworks.threadpool.pool.ThreadPool;
import com.sbt.javaschool.homeworks.threadpool.pool.ThreadPoolImpl;
import com.sbt.javaschool.homeworks.threadpool.queue.Task;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPoolImpl(2);
        threadPool.start();

        for (int i = 0; i < 10; i++) {
            Task task = new Task(i);
            threadPool.execute(task);
        }
    }
}
