package com.sbt.javaschool.homeworks.executionmanager;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
