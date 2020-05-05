package com.mind.runner.business.usecase;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

public class UpdateAthlete {

    private final AthleteRepository athleteRepository;

    public UpdateAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete updateIdempotent(Long id, Athlete newAthlete){
        Athlete athlete = athleteRepository.findById(id);
        newAthlete.setId(athlete.getId());
        return athleteRepository.update(newAthlete);
    }

    public Athlete update(Long id, Athlete newAthlete){
        Athlete athlete = athleteRepository.findById(id);
        if(newAthlete.getAge() != null) {
            athlete.setAge(newAthlete.getAge());
        }
        if(newAthlete.getFirstName() != null) {
            athlete.setFirstName(newAthlete.getFirstName());
        }
        if(newAthlete.getLastName() != null) {
            athlete.setLastName(newAthlete.getLastName());
        }
        if(newAthlete.getGoal() != null) {
            athlete.setGoal(newAthlete.getGoal());
        }
        return athleteRepository.update(athlete);
    }

}
