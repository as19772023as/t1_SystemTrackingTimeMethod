package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceSaveData;

@Component
@RequiredArgsConstructor
@Aspect
@Slf4j
public class TrackTimeCheckerAspect {

    private final ServiceSaveData serviceSaveData;
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
    }

    @After("afterPointcut()")
    public void afterTrackTime(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        long endTime = System.currentTimeMillis();
        serviceSaveData.saveData(methodName, endTime - startTime);
    }

}

