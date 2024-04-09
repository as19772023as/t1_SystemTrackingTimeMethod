package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositoryStatisticsJpa;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositoryStatisticsManager;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceStatistics {

    private final RepositoryStatisticsManager repositoryStatistics;
    private final RepositoryStatisticsJpa repositoryStatistic;

    @Transactional
    public List<TimingMethods> getTotalTimeByMethod(String method) {
        return repositoryStatistic.getTotalTimeByMethod(method);
    }

    @Transactional
    public List<TimingMethods> getTotalTimeByMethodGroup(String method1, String method2) {
        return repositoryStatistic.getTotalTimeByMethodGroup(method1, method2);
    }

    @Transactional
    public List<TimingMethods> getAvgTimeByMethod(String method) {
        return repositoryStatistics.getAvgTimeByMethod(method);
    }

    @Transactional
    public List<TimingMethods> getAvgTimeByMethodGroup(String method1, String method2) {
        return repositoryStatistics.getAvgTimeByMethodGroup(method1, method2);
    }

    @Transactional
    public void saveData(String methodName, long totalTime) {
        TimingMethods etm = TimingMethods
                .builder()
                .methodName(methodName)
                .totalTime(totalTime)
                .build();
        repositoryStatistic.save(etm);
    }
}
