package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceSaveData;

@Component
@Aspect
@RequiredArgsConstructor
@Slf4j
public class TrackAsyncTimeCheckerAspect {

    private final ServiceSaveData serviceSaveData;
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
    }


    @Async
    @AfterReturning("afterReturningPointcut()")
    public void afterTrackAsyncTime(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        long endTime = System.currentTimeMillis();
        serviceSaveData.saveData(methodName, endTime - startTime);
    }

}
