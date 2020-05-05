package com.mind.runner.adapter.outbound.repository.jpa;

import com.mind.runner.adapter.outbound.repository.jpa.model.AthleteJpaEntity;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AthleteJpaRepository implements AthleteRepository {

    @Autowired
    AthleteJpaRepositoryInterface athleteJpaRepositoryInterface;

    public Athlete save(Athlete athlete) {
        AthleteJpaEntity athleteJpaEntity = athleteJpaRepositoryInterface.save(AthleteJpaEntity.toAthleteJpaEntity(athlete));
        return convertToAthlete(athleteJpaEntity);
    }

    public Athlete update(Athlete athlete) {
        AthleteJpaEntity athleteJpaEntity = athleteJpaRepositoryInterface.save(AthleteJpaEntity.toAthleteJpaEntity(athlete));
        return convertToAthlete(athleteJpaEntity);
    }

    public void deleteById(Long id) {
        athleteJpaRepositoryInterface.deleteById(id);
    }

    public Athlete findById(Long id) {
        Optional<AthleteJpaEntity> athleteJpaEntity = athleteJpaRepositoryInterface.findById(id);
        return athleteJpaEntity.isPresent() ? athleteJpaEntity.get().toAthlete() : null;
    }

    public List<Athlete> findAll() {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findAll();
        return convertToAthlete(result);
    }

    public List<Athlete> findByFirstNameIsStartingWith(String firstName) {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByFirstNameIsStartingWith(firstName);
        List<Athlete> athletes = result.stream().map(AthleteJpaEntity::toAthlete).collect(Collectors.toList());
        return athletes;
    }

    public List<Athlete> findByAgeBetween(Integer from, Integer to) {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByAgeBetween(from, to);
        return convertToAthlete(result);
    }

    public List<Athlete> findByGoalIsLike(String goal) {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByGoalIsLike(goal);
        return convertToAthlete(result);
    }

    public List<Athlete> findByOrderByCreatedAtDesc() {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByOrderByCreatedAtDesc();
        return convertToAthlete(result);
    }

    public List<Athlete> findAthleteBySoccerTraining() {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findAthleteJpaEntityBySoccerTraining();
        return convertToAthlete(result);
    }

    private List<Athlete> convertToAthlete(List<AthleteJpaEntity> result) {
        List<Athlete> athletes = result.stream().
                map(AthleteJpaEntity::toAthlete).
                collect(Collectors.toList());
        return athletes;
    }

    private Athlete convertToAthlete(AthleteJpaEntity result) {
        Athlete athlete = result.toAthlete();
        return athlete;
    }

}
