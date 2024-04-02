package ru.strebkov.t1_SystemTrackingTimeMethod.controller;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceExample;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class ControllerExample {
    private final ServiceExample serviceExample;

    @TrackAsyncTime
    @Async
    @GetMapping("/sleep") //localhost:8080/sleep?sleep=4000
    public CompletableFuture<String> getSleep(@RequestParam(value = "sleep", required = false) int runtimeSimulation)
            throws InterruptedException {

        return serviceExample.serveAsync(runtimeSimulation);
    }

}
