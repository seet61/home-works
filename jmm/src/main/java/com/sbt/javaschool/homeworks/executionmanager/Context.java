package com.sbt.javaschool.homeworks.executionmanager;

public interface Context {
    /**
     * Метод getCompletedTaskCount() возвращает количество тасков, которые на текущий момент успешно выполнились.
     * @return
     */
    int getCompletedTaskCount();

    /**
     * Метод getFailedTaskCount() возвращает количество тасков, при выполнении которых произошел Exception.
     * @return
     */
    int getFailedTaskCount();

    /**
     * Метод getInterruptedTaskCount() возвращает количество тасков, которые не были выполены из-за отмены
     * @return
     */
    int getInterruptedTaskCount();

    /**
     * Метод interrupt() отменяет выполнения тасков, которые еще не начали выполняться.
     */
    void interrupt();

    /**
     * Метод isFinished() вернет true, если все таски были выполнены или отменены, false в противном случае
     * @return
     */
    boolean isFinished();
}
