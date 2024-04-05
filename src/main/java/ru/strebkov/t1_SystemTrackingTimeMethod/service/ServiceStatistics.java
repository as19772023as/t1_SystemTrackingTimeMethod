package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositoryStatistics;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceStatistics {

    private final RepositoryStatistics repositoryStatistics;

    @Transactional
    public List<TimingMethods> getTotalTimeByMethod(String method) {
        return repositoryStatistics.getTotalTimeByMethod(method);
    }

    @Transactional
    public List<TimingMethods> getAvgTimeByMethod(String method) {
        return repositoryStatistics.getAvgTimeByMethod(method);
    }

    @Transactional
    public List<TimingMethods> getTotalTimeByMethodGroup(String method1, String method2) {
        return repositoryStatistics.getTotalTimeByMethodGroup(method1, method2);
    }

    @Transactional
    public List<TimingMethods> getAvgTimeByMethodGroup(String method1, String method2) {
        return repositoryStatistics.getAvgTimeByMethodGroup(method1, method2);
    }
}
