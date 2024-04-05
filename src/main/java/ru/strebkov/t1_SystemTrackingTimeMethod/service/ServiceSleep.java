package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositorySleep;

@Service
@RequiredArgsConstructor
public class ServiceSleep {
    private final RepositorySleep repositoryExample;

    public String saveSleep(int runtimeSimulation) {
        return repositoryExample.saveSleep(runtimeSimulation);
    }
}
