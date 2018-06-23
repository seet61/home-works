package com.sbt.javaschool.homeworks.threadpool.pool;

import com.sbt.javaschool.homeworks.threadpool.queue.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadPoolImplTest {
    ThreadPool threadPool = new ThreadPoolImpl(2);

    @Test
    public void start() {
        threadPool.start();
    }

    @Test
    public void execute() {
        Task task = new Task(1);
        threadPool.execute(task);
    }
}