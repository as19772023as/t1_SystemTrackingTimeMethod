package ru.strebkov.t1_SystemTrackingTimeMethod.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.Person;
import ru.strebkov.t1_SystemTrackingTimeMethod.service.ServicePerson;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class ControllerPerson {

    private final ServicePerson service;

    @TrackTime
    @GetMapping("/by-city") //localhost:8080/persons/by-city?city=Moscow
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return service.findByCityOfLivingS(city);
    }

}
