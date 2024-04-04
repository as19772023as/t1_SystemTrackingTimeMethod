package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;

@Repository
public class RepositorySaveData {
    @PersistenceContext
    private EntityManager entityManager;

    public TimingMethods saveDataRepository(String methodName, long totalTime) {
        TimingMethods etm = TimingMethods
                .builder()
                .methodName(methodName)
                .totalTime(totalTime)
                .build();
        entityManager.persist(etm);
        return etm;
    }
}
