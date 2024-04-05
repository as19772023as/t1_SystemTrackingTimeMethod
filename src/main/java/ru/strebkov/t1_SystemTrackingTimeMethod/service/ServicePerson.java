package ru.strebkov.t1_SystemTrackingTimeMethod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.t1_SystemTrackingTimeMethod.annotation.TrackTime;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.Person;
import ru.strebkov.t1_SystemTrackingTimeMethod.repository.RepositoryPerson;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePerson {
    private final RepositoryPerson repository;

    public List<Person> findByCityOfLivingS(String city) {
        return repository.findByCityOfLiving(city);
    }

}
