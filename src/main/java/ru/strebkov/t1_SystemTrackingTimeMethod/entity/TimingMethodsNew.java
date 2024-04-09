package ru.strebkov.t1_SystemTrackingTimeMethod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


public class TimingMethodsNew {
    private String methodName;
    private long totalTime;

    public TimingMethodsNew(String methodName, long totalTime) {
        this.methodName = methodName;
        this.totalTime = totalTime;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
}
