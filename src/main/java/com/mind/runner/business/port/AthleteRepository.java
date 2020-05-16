package com.mind.runner.business.port;

import com.mind.runner.business.entity.Athlete;
import java.util.List;
import java.util.Optional;

/**
 * API contract. The Adapter provider must implement this interface.
 */

public interface AthleteRepository {

    Athlete save(Athlete athlete);

    Athlete update(Athlete athlete);

    void deleteById(Long id);

    Optional<Athlete> findById(Long id);

    List<Athlete> findAll();

    List<Athlete> findByFirstNameIsStartingWith(String firstName);

    List<Athlete> findByAgeBetween(Integer from, Integer to);

    List<Athlete> findByGoalIsLike(String goal);

    List<Athlete> findByOrderByCreatedAtDesc();

    List<Athlete> findAthleteBySoccerTraining();
}