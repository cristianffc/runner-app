package com.mind.runner.business.usecase;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.outbound.AthleteRepository;

public class CreateAthlete {

    private final AthleteRepository athleteRepository;

    public CreateAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void create(Athlete athlete){
        athleteRepository.create(athlete);
    }

}
