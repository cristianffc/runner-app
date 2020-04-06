package com.mind.runner.business.usecase;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.outbound.AthleteRepository;
import java.util.List;

public class FindAthlete {

    private final AthleteRepository athleteRepository;

    public FindAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete findById(Long id) {
        return athleteRepository.findById(id);
    }

    public List<Athlete> findByFirstNameIsStartingWith(String firstName) {
        return athleteRepository.findByFirstNameIsStartingWith(firstName);
    }

    public List<Athlete> findByAgeBetween(Integer from, Integer to) {
        return athleteRepository.findByAgeBetween(from,to);
    }

    public List<Athlete> findByGoalIsLike(String goal) {
        return athleteRepository.findByGoalIsLike(goal);
    }

    public List<Athlete> findByOrderByCreatedAtDesc() {
        return athleteRepository.findByOrderByCreatedAtDesc();
    }

    public List<Athlete> findAthleteBySoccerTraining() {
        return athleteRepository.findAthleteBySoccerTraining();
    }

}