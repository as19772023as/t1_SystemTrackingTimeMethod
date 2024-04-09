package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceStatistics;

@Component
@Aspect
@RequiredArgsConstructor
@Scope("prototype")
@Slf4j
public class TrackAsyncTimeCheckerAspect {

    private final ServiceStatistics serviceStatistics;
    private long startTime;

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime)")
    public void beforePointcut() {
    }

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime)")
    public void afterPointcut() {
    }

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime)")
    public void afterReturningPointcut() {
    }

    @Before("beforePointcut()")
    public void beforeTrackAsyncTime() {
        startTime = System.currentTimeMillis();
        log.info("Время старта Asin = " + startTime);
    }


    @Async
    @AfterReturning("afterReturningPointcut()")
    public void afterTrackAsyncTime(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        long endTime = System.currentTimeMillis();
        serviceStatistics.saveData(methodName, endTime - startTime);
        log.info("Время stop Asin = " + endTime);
        long x = endTime - startTime;
        log.info("Время  ASin = " + x);
    }

}
