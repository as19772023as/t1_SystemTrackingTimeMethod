package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceExample {

    //TODO нужно обработать исключение?
    @TrackAsyncTime
    @Async
    public CompletableFuture<String> serveAsync(int runtimeSimulation) throws InterruptedException {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
        Thread.sleep(runtimeSimulation);

        return CompletableFuture.completedFuture("result");
    }
}
