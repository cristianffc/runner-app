package com.mind.runner.adapter.outbound.repository.jpa;

import com.mind.runner.adapter.outbound.repository.jpa.model.AthleteJpaEntity;
import org.springframework.data.repository.CrudRepository;

interface AthleteJpaRepositoryInterface extends CrudRepository<AthleteJpaEntity, Long> {
}
