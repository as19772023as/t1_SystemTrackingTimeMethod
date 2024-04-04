package ru.strebkov.t1_SystemTrackingTimeMethod.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.TimingMethods;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServiceStatistics;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class ControllerStatistics {

    private final ServiceStatistics serviceStatistics;

    @GetMapping("/totalTime") // localhost:8080/statistics/totalTime?method=getSleep
    public List<TimingMethods> getTotalTimeByMethod(@RequestParam(value = "method", required = false) String method) {
        return serviceStatistics.getTotalTimeByMethod(method);
    }

    @GetMapping("/avgTime") // localhost:8080/statistics/avgTime?method=getPersonsByCity
    public List<TimingMethods> getAvgTimeByMethod(@RequestParam(value = "method", required = false) String method) {
        return serviceStatistics.getAvgTimeByMethod(method);
    }

    @GetMapping("/totalTime/group") // localhost:8080/statistics/totalTime/group?method1=getSleep&method2=getPersonsByCity
    public List<TimingMethods> getTotalTimeByMethodGroup(@RequestParam(value = "method1", required = false) String method1,
                                                         @RequestParam(value = "method2", required = false) String method2) {
        return serviceStatistics.getTotalTimeByMethodGroup(method1, method2);
    }

    @GetMapping("/avgTime/group") // localhost:8080/statistics/avgTime/group?method1=getSleep&method2=getPersonsByCity
    public List<TimingMethods> getAvgTimeByMethodGroup(@RequestParam(value = "method1", required = false) String method1,
                                                         @RequestParam(value = "method2", required = false) String method2) {
        return serviceStatistics.getAvgTimeByMethodGroup(method1, method2);
    }

}
