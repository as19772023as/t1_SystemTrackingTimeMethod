package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.ExecutionTimeOfMethods;

@Component
@Aspect
@Slf4j
public class TrackTimeCheckerAspect {
    @PersistenceContext
    private EntityManager entityManager;
    long startTime, endTime, totalTime;
    String methodName;


    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime)")
    public void aroundPointcut() {
    }

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime)")
    public void afterPointcut() {
    }


    @Around("aroundPointcut()")
    public Object aroundTrackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        startTime = System.currentTimeMillis();
        methodName = proceedingJoinPoint.getSignature().getName(); // читает имя метода

        log.info("Выполнение метода {} ", methodName);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        Object result = proceedingJoinPoint.proceed(); //  результат метода
        log.info("Метод {} выполнился за {} мс ", methodName, totalTime);
        return result;

    }
    //@Transactional
    @After(value = "afterPointcut()")
    public void afterTrackTime() {
        saveData(methodName, totalTime);
    }

    //@Async
    @Transactional
    public void saveData(String methodName, long totalTime) {
        ExecutionTimeOfMethods etm = ExecutionTimeOfMethods
                .builder()
                .methodName(methodName)
                .totalTime(totalTime)
                .build();
        entityManager.persist(etm);

    }
}
