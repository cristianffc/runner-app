package com.mind.runner.business.port.outbound;

import com.mind.runner.business.entity.Athlete;
import java.util.List;

public interface AthleteRepository {

    void save(Athlete athlete);

    void update(Athlete athlete);

    void deleteById(Long id);

    Athlete findById(Long id);

    List<Athlete> findByFirstNameIsStartingWith(String firstName);

    List<Athlete> findByAgeBetween(Integer from, Integer to);

    List<Athlete> findByGoalIsLike(String goal);

    List<Athlete> findByOrderByCreatedAtDesc();

    List<Athlete> findAthleteBySoccerTraining();

}
