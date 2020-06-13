package com.mind.runner.adapter.outbound.jpa;

import com.mind.runner.adapter.outbound.jpa.entity.AthleteJpaEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AthleteJpaRepositoryInterface extends CrudRepository<AthleteJpaEntity, Long> {

    List<AthleteJpaEntity> findByFirstNameIsStartingWith(String firstName);

    List<AthleteJpaEntity> findAll();

    List<AthleteJpaEntity> findByEmailIsLike(String email);

    List<AthleteJpaEntity> findByOrderByCreatedAtDesc();

}