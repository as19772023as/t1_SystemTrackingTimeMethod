package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;

import java.util.List;

@Repository
public class RepositoryStatisticsManager {
    @PersistenceContext
    private EntityManager entityManager;

//    public List<TimingMethods> getTotalTimeByMethod(String method) {
//        return entityManager
//                .createQuery("select t.methodName, t.totalTime " +
//                        "from TimingMethods t " +
//                        "where t.methodName = ?1 " +
//                        "order by t.totalTime")
//                .setParameter(1, method)
//                .getResultList();
//    }
//
//    public List<TimingMethods> getTotalTimeByMethodGroup(String method1, String method2) {
//        return entityManager.createQuery("SELECT t " +
//                        "FROM TimingMethods t " +
//                        "WHERE t.methodName = :method1 OR t.methodName = :method2 " +
//                        "order by t.totalTime", TimingMethods.class)
//                .setParameter("method1", method1)
//                .setParameter("method2", method2)
//                .getResultList();
//    }

    public List<TimingMethods> getAvgTimeByMethod(String method) {
        return entityManager
                .createQuery("select  avg(t.totalTime), t.methodName " +
                        "from TimingMethods t " +
                        "where t.methodName = ?1" +
                        "group by t.methodName")
                .setParameter(1, method)
                .getResultList();
    }

    public List<TimingMethods> getAvgTimeByMethodGroup(String method1, String method2) {
        return entityManager.createQuery("SELECT  avg(t.totalTime) " +
                        "FROM TimingMethods t " +
                        "WHERE t.methodName = :method1 OR t.methodName = :method2  " +
                        "group by t.methodName", TimingMethods.class)
                .setParameter("method1", method1)
                .setParameter("method2", method2)
                .getResultList();
    }

}
