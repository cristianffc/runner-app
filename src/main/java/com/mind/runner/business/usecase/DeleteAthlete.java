package com.mind.runner.business.usecase;

import com.mind.runner.business.port.AthleteRepository;

public class DeleteAthlete {

    private final AthleteRepository athleteRepository;

    public DeleteAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void delete(Long id){
        athleteRepository.deleteById(id);
    }

}
