package com.mind.runner.business.usecase.athlete;

import com.mind.runner.business.port.AthleteRepository;

/**
 * Delete athlete user story
 */

public class DeleteAthlete {

    private final AthleteRepository athleteRepository;

    public DeleteAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void delete(Long id) {
        athleteRepository.deleteById(id);
    }
}
