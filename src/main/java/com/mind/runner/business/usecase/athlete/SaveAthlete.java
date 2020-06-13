package com.mind.runner.business.usecase.athlete;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

/*
 * Save athlete user story
 */

public class SaveAthlete {

    private final AthleteRepository athleteRepository;

    public SaveAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete save(Athlete athlete){
        return athleteRepository.save(athlete);
    }
}