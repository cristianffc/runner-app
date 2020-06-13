package com.mind.runner.adapter.outbound.jpa;

import com.mind.runner.adapter.outbound.jpa.entity.TrackJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackJpaRepositoryInterface extends CrudRepository<TrackJpaEntity, Long> {

    List<TrackJpaEntity> findAll();

}