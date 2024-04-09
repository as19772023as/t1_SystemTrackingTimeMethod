package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositorySleep;

@Service
@RequiredArgsConstructor
public class ServiceSleep {
    private final RepositorySleep repositorySleep;

    public String saveSleep(int runtimeSimulation) {
        try {
            Thread.sleep(runtimeSimulation);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return repositorySleep.saveSleep(runtimeSimulation);
    }
}
