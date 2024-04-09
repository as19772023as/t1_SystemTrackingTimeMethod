package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.strebkov.t1_SystemTrackingTimeMethod.exception.PersonException;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceStatistics;

@Component
@RequiredArgsConstructor
@Aspect
@Scope("prototype")
@Slf4j
public class TrackTimeCheckerAspect {

    private final ServiceStatistics serviceStatistics;
    private long startTime;

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime)")
    public void beforePointcut() {
    }

    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime)")
    public void afterPointcut() {
    }

    @Before("beforePointcut()")
    public void beforeTrackTime() {

        startTime = System.currentTimeMillis();
        log.info("Время старта Sinx = " + startTime );
    }

    @After("afterPointcut()")
    public void afterTrackTime(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        if (methodName == null) {
            throw new PersonException("Имя метода не должно быть null ");
        }
        long endTime = System.currentTimeMillis();
        serviceStatistics.saveData(methodName, endTime - startTime);
        log.info("Время stop Sinx = " + endTime );
        long x = endTime - startTime;
        log.info("Время  Sinx = " + x );
    }

}

