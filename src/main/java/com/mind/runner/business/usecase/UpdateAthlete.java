package com.mind.runner.business.usecase;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

import java.util.Optional;

/**
 * Update athlete user story
 */

public class UpdateAthlete {

    private final AthleteRepository athleteRepository;

    public UpdateAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Optional<Athlete> updateIdempotent(Long id, Athlete newAthlete) {
        Optional<Athlete> athlete = athleteRepository.findById(id);
        if (athlete.isPresent()) {
            newAthlete.setId(athlete.get().getId());
            return Optional.of(athleteRepository.update(newAthlete));
        }
        return athlete;
    }

    public Optional<Athlete> update(Long id, Athlete newAthlete) {
        Optional<Athlete> athlete = athleteRepository.findById(id);
        if(athlete.isPresent()) {
            if (newAthlete.getAge() != null) {
                athlete.get().setAge(newAthlete.getAge());
            }
            if (newAthlete.getFirstName() != null) {
                athlete.get().setFirstName(newAthlete.getFirstName());
            }
            if (newAthlete.getLastName() != null) {
                athlete.get().setLastName(newAthlete.getLastName());
            }
            if (newAthlete.getGoal() != null) {
                athlete.get().setGoal(newAthlete.getGoal());
            }
            return Optional.of(athleteRepository.update(athlete.get()));
        }
        return athlete;
    }
}