package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorySleep {
    public String saveSleep(int runtimeSimulation) {
        try {
            Thread.sleep(runtimeSimulation);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "result";
    }

}