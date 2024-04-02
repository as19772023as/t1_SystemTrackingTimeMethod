package ru.strebkov.t1_SystemTrackingTimeMethod.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class TrackAsyncTimeCheckerAspect {
    @Pointcut("@annotation(ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime)")
    public void trackAsyncTime() {
    }

    @Around("trackAsyncTime()")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String methodName = proceedingJoinPoint.getSignature().getName(); // читает имя метода
        Object[] methodArgs = proceedingJoinPoint.getArgs(); //  читает аргументы

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        Object result = proceedingJoinPoint.proceed(); //  результат метода

        stopWatch.stop();

        log.info("Метод {} выполнился за {} мс с результатом {}", methodName, stopWatch.getTotalTimeMillis(), result);
        return result;
    }
}
