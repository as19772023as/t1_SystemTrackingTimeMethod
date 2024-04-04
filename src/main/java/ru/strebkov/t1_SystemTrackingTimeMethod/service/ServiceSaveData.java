package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositorySaveData;

@Service
@RequiredArgsConstructor
public class ServiceSaveData {
    private final RepositorySaveData repositorySaveData;


    @Transactional
    public TimingMethods saveData(String methodName, long totalTime) {
        return repositorySaveData.saveDataRepository(methodName, totalTime);
    }

}
