package com.mind.runner.adapter.outbound.jpa;

import com.mind.runner.adapter.outbound.jpa.entity.TrackJpaEntity;
import com.mind.runner.business.entity.Track;
import com.mind.runner.business.port.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class TrackJpaRepositoryImpl implements TrackRepository {

    TrackJpaRepositoryInterface trackJpaRepositoryInterface;

    @Autowired
    public void setAthleteJpaRepositoryInterface(TrackJpaRepositoryInterface trackJpaRepositoryInterface) {
        this.trackJpaRepositoryInterface = trackJpaRepositoryInterface;
    }

    public Track save(Track athlete) {
        TrackJpaEntity athleteJpaEntity =
                trackJpaRepositoryInterface.save(TrackJpaEntity.trackJpaEntityBuilder(athlete));
        return athleteJpaEntity.trackBuilder();
    }

    public Track update(Track athlete) {
        TrackJpaEntity athleteJpaEntity =
                trackJpaRepositoryInterface.save(TrackJpaEntity.trackJpaEntityBuilder(athlete));
        return athleteJpaEntity.trackBuilder();
    }

    public void deleteById(Long id) {
        trackJpaRepositoryInterface.deleteById(id);
    }

    public Optional<Track> findById(Long id) {
        Optional<TrackJpaEntity> athleteJpaEntity = trackJpaRepositoryInterface.findById(id);
        if (athleteJpaEntity.isPresent()) {
            return Optional.of(athleteJpaEntity.get().trackBuilder());
        }
        return Optional.empty();
    }

    public List<Track> findAll() {
        List<TrackJpaEntity> result = trackJpaRepositoryInterface.findAll();
        return result.stream()
                     .map(TrackJpaEntity::trackBuilder)
                     .collect(toList());
    }

}