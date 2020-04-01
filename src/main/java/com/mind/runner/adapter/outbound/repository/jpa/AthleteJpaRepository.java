package com.mind.runner.adapter.outbound.repository.jpa;

import com.mind.runner.adapter.outbound.repository.jpa.model.AthleteJpaEntity;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.outbound.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AthleteJpaRepository implements AthleteRepository {

    @Autowired
    AthleteJpaRepositoryInterface athleteJpaRepositoryInterface;

    public void create(Athlete athlete) {
        athleteJpaRepositoryInterface.save(AthleteJpaEntity.toAthleteJpaEntity(athlete));
    }
}
