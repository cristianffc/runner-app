package com.mind.runner.adapter.outbound.jpa;

import com.mind.runner.adapter.outbound.jpa.entity.AthleteJpaEntity;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.port.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class AthleteJpaRepositoryImpl implements AthleteRepository {

    AthleteJpaRepositoryInterface athleteJpaRepositoryInterface;

    @Autowired
    public void setAthleteJpaRepositoryInterface(final AthleteJpaRepositoryInterface athleteJpaRepositoryInterface) {
        this.athleteJpaRepositoryInterface = athleteJpaRepositoryInterface;
    }

    public Athlete save(final Athlete athlete) {
        final var athleteJpaEntity =
                athleteJpaRepositoryInterface.save(AthleteJpaEntity.athleteJpaEntityBuilder(athlete));
        return athleteJpaEntity.athleteBuilder();
    }

    public Athlete update(final Athlete athlete) {
        final var athleteJpaEntity =
                athleteJpaRepositoryInterface.save(AthleteJpaEntity.athleteJpaEntityBuilder(athlete));
        return athleteJpaEntity.athleteBuilder();
    }

    public void deleteById(final Long id) {
        athleteJpaRepositoryInterface.deleteById(id);
    }

    public Optional<Athlete> findById(final Long id) {
        final var athleteJpaEntity = athleteJpaRepositoryInterface.findById(id);
        if (athleteJpaEntity.isPresent()) {
            return Optional.of(athleteJpaEntity.get()
                    .athleteBuilder());
        }
        return Optional.empty();
    }

    public List<Athlete> findAll() {
        final var result = athleteJpaRepositoryInterface.findAll();
        return result.stream()
                .map(AthleteJpaEntity::athleteBuilder)
                .collect(toList());
    }

    public List<Athlete> findByFirstNameIsStartingWith(final String firstName) {
        final var result = athleteJpaRepositoryInterface.findByFirstNameIsStartingWith(firstName);
        return result.stream()
                .map(AthleteJpaEntity::athleteBuilder)
                .collect(toList());
    }

    public List<Athlete> findByEmailIsLike(final String goal) {
        final var result = athleteJpaRepositoryInterface.findByEmailIsLike(goal);
        return result.stream()
                .map(AthleteJpaEntity::athleteBuilder)
                .collect(toList());
    }

    public List<Athlete> findByOrderByCreatedAtDesc() {
        final var result = athleteJpaRepositoryInterface.findByOrderByCreatedAtDesc();
        return result.stream()
                .map(AthleteJpaEntity::athleteBuilder)
                .collect(toList());
    }

}