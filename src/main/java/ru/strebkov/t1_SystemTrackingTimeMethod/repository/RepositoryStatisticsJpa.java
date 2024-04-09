package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;

import java.util.List;

@Repository
public interface RepositoryStatisticsJpa extends JpaRepository<TimingMethods, Long> {
    @Query("SELECT tm FROM TimingMethods tm WHERE tm.methodName = :method")
    List<TimingMethods> getTotalTimeByMethod(@Param("method") String method);

    @Query("select t from TimingMethods t " +
            "where t.methodName in (:method1 , :method2) " +
            "order by t.totalTime" )
    List<TimingMethods> getTotalTimeByMethodGroup(
            @Param("method1") String method1,
            @Param("method2") String method2);

//    @Query( value = "select avg(tm.time_total)\n" +
//            "from t1persons.timing_methods tm \n" +
//            "where tm.name_method = :method", nativeQuery = true)
//    @Query("SELECT new ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethodsNew ( t.methodName, AVG(t.totalTime)) FROM TimingMethods t WHERE t.methodName = :method group by t.methodName")
//    @Query("select avg(t.totalTime) from TimingMethods t where methodName = :method ")
//@Query("SELECT new TimingMethods (t.methodName, AVG(t.totalTime)) FROM TimingMethods t WHERE t.methodName = :method group by t.methodName")
//   List<TimingMethods> getAvgTimeByMethod(@Param("method") String method);


//    @Query("SELECT avg(t.totalTime) " +
//            "FROM TimingMethods t " +
//            "WHERE t.methodName = :method1 OR t.methodName = :method2  " +
//            "group by t.methodName")
////    @Query(value = "select name_method, avg(time_total) \n" +
////            "from t1persons.timing_methods tm \n" +
////            "where name_method  in (:method1 , :method2) group  by name_method ", nativeQuery = true)
//    List<TimingMethods> getAvgTimeByMethodGroup(
//            @Param("method1") String method1,
//            @Param("method2") String method2);

}
