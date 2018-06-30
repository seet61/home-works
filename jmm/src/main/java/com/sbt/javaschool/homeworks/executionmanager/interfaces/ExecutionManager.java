package com.sbt.javaschool.homeworks.executionmanager.interfaces;

import com.sbt.javaschool.homeworks.executionmanager.interfaces.Context;

public interface ExecutionManager {
    /**
     * Метод execute принимает массив тасков,
     * это задания которые ExecutionManager должен выполнять параллельно
     * (в вашей реализации пусть будет в своем пуле потоков).
     * После завершения всех тасков должен выполниться callback (ровно 1 раз).
     * @param callback
     * @param tasks
     * @return
     */
    Context execute(Runnable callback, Runnable... tasks);
}
