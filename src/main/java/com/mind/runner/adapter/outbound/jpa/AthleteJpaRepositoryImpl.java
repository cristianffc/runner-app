package com.mind.runner.adapter.outbound.jpa;

import com.mind.runner.adapter.outbound.jpa.entity.AthleteJpaEntity;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

@Repository
public class AthleteJpaRepositoryImpl implements AthleteRepository {

    AthleteJpaRepositoryInterface athleteJpaRepositoryInterface;

    @Autowired
    public void setAthleteJpaRepositoryInterface(AthleteJpaRepositoryInterface athleteJpaRepositoryInterface) {
        this.athleteJpaRepositoryInterface = athleteJpaRepositoryInterface;
    }

    public Athlete save(Athlete athlete) {
        AthleteJpaEntity athleteJpaEntity =
                athleteJpaRepositoryInterface.save(AthleteJpaEntity.athleteJpaEntityBuilder(athlete));
        return athleteJpaEntity.athleteBuilder();
    }

    public Athlete update(Athlete athlete) {
        AthleteJpaEntity athleteJpaEntity =
                athleteJpaRepositoryInterface.save(AthleteJpaEntity.athleteJpaEntityBuilder(athlete));
        return athleteJpaEntity.athleteBuilder();
    }

    public void deleteById(Long id) {
        athleteJpaRepositoryInterface.deleteById(id);
    }

    public Optional<Athlete> findById(Long id) {
        Optional<AthleteJpaEntity> athleteJpaEntity = athleteJpaRepositoryInterface.findById(id);
        if (athleteJpaEntity.isPresent()) {
            return Optional.of(athleteJpaEntity.get()
                                               .athleteBuilder());
        }
        return Optional.empty();
    }

    public List<Athlete> findAll() {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findAll();
        return result.stream()
                     .map(AthleteJpaEntity::athleteBuilder)
                     .collect(toList());
    }

    public List<Athlete> findByFirstNameIsStartingWith(String firstName) {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByFirstNameIsStartingWith(firstName);
        return result.stream()
                     .map(AthleteJpaEntity::athleteBuilder)
                     .collect(toList());
    }

    public List<Athlete> findByEmailIsLike(String goal) {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByEmailIsLike(goal);
        return result.stream()
                     .map(AthleteJpaEntity::athleteBuilder)
                     .collect(toList());
    }

    public List<Athlete> findByOrderByCreatedAtDesc() {
        List<AthleteJpaEntity> result = athleteJpaRepositoryInterface.findByOrderByCreatedAtDesc();
        return result.stream()
                     .map(AthleteJpaEntity::athleteBuilder)
                     .collect(toList());
    }

}