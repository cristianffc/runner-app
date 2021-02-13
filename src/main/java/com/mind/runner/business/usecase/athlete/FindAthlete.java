package com.mind.runner.business.usecase.athlete;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

import java.util.List;
import java.util.Optional;

/**
 * Find athlete user story
 */

public class FindAthlete {

    private final AthleteRepository athleteRepository;

    public FindAthlete(final AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Optional<Athlete> findById(final Long id) {
        return athleteRepository.findById(id);
    }

    public List<Athlete> findAll() {
        return athleteRepository.findAll();
    }

    public List<Athlete> findByFirstNameIsStartingWith(final String firstName) {
        return athleteRepository.findByFirstNameIsStartingWith(firstName);
    }

    public List<Athlete> findByEmailIsLike(final String email) {
        return athleteRepository.findByEmailIsLike(email);
    }

    public List<Athlete> findByOrderByCreatedAtDesc() {
        return athleteRepository.findByOrderByCreatedAtDesc();
    }

}