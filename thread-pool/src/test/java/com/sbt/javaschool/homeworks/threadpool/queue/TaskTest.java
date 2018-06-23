package com.sbt.javaschool.homeworks.threadpool.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    private Task task = new Task(1);

    @Test
    public void run() {
        task.run();
    }
}