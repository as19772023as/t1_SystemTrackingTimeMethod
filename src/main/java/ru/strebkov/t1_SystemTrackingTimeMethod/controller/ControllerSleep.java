package ru.strebkov.t1_SystemTrackingTimeMethod.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackAsyncTime;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceSleep;

@RestController
@RequiredArgsConstructor
public class ControllerSleep {
    private final ServiceSleep serviceExample;

    @TrackAsyncTime
    @GetMapping("/sleep") //localhost:8080/sleep?sleep=4000
    public String getSleep(@RequestParam(value = "sleep", required = false) int runtimeSimulation)
            throws InterruptedException {
        return serviceExample.saveSleep(runtimeSimulation);
    }

}
