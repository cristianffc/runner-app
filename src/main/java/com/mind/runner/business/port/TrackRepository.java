package com.mind.runner.business.port;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.entity.Track;

import java.util.List;
import java.util.Optional;

/**
 * API contract. The Adapter provider must implement this interface.
 */

public interface TrackRepository {

    Track save(Track track);

    Track update(Track track);

    void deleteById(Long id);

    Optional<Track> findById(Long id);

    List<Track> findAll();

}