package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import org.springframework.stereotype.Repository;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime;

@Repository
public class RepositorySleep {
    //@TrackAsyncTime
    public String saveSleep(int runtimeSimulation) {
        return "result";
    }

}