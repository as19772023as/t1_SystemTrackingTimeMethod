package ru.strebkov.t1_SystemTrackingTimeMethod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.strebkov.t1_SystemTrackingTimeMethod.entity.Person;

import java.util.List;

@Repository
public interface RepositoryPerson extends JpaRepository<Person, Integer> {
    List<Person> findByCityOfLiving(String cityOfLiving);

}
