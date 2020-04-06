package com.mind.runner.adapter.outbound.repository.jpa;

import com.mind.runner.adapter.outbound.repository.jpa.model.AthleteJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

interface AthleteJpaRepositoryInterface extends CrudRepository<AthleteJpaEntity, Long> {

    List<AthleteJpaEntity> findByFirstNameIsStartingWith(String firstName);

    List<AthleteJpaEntity> findByAgeBetween(Integer from, Integer to);

    List<AthleteJpaEntity> findByGoalIsLike(String goal);

    List<AthleteJpaEntity> findByOrderByCreatedAtDesc();

    @Query("Select a from AthleteJpaEntity a where a.goal='Soccer'")
    List<AthleteJpaEntity> findAthleteJpaEntityBySoccerTraining();

}
