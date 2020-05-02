package com.mind.runner.business.usecase;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

public class UpdateAthlete {

    private final AthleteRepository athleteRepository;

    public UpdateAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void update(Athlete athlete){
        athleteRepository.update(athlete);
    }

}
