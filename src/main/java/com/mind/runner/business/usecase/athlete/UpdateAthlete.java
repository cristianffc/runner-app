package com.mind.runner.business.usecase.athlete;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;

import java.util.Optional;

import static java.util.Optional.of;

/**
 * Update athlete user story
 */

public class UpdateAthlete {

    private final AthleteRepository athleteRepository;

    public UpdateAthlete(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Optional<Athlete> updateIdempotent(Long id, Athlete newAthlete) {
        var athlete = athleteRepository.findById(id);

        if (athlete.isPresent()) {
            Athlete athleteToUpdate = Athlete.builder()
                    .withId(id)
                    .withBirth(newAthlete.getBirth())
                    .withFirstName(newAthlete.getFirstName())
                    .withLastName(newAthlete.getLastName())
                    .withCreatedAt(newAthlete.getCreatedAt())
                    .build();

            return of(athleteRepository.update(athleteToUpdate));
        }
        return athlete;
    }

    public Optional<Athlete> update(Long id, Athlete newAthlete) {
        Optional<Athlete> athlete = athleteRepository.findById(id);

        if (athlete.isPresent()) {
            var birth = newAthlete.getBirth() != null ?
                    newAthlete.getBirth() : athlete.get().getBirth();
            var firstName = newAthlete.getFirstName() != null ?
                    newAthlete.getFirstName() : athlete.get().getFirstName();
            var lastName = newAthlete.getLastName() != null ?
                    newAthlete.getLastName() : athlete.get().getLastName();
            var email = newAthlete.getEmail() != null ?
                    newAthlete.getEmail() : athlete.get().getEmail();

            Athlete athleteToUpdate = Athlete.builder()
                    .withId(id)
                    .withCreatedAt(athlete.get().getCreatedAt())
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withEmail(email)
                    .build();

            return of(athleteRepository.update(athleteToUpdate));
        }
        return athlete;
    }
}