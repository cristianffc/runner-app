package com.mind.runner.business.usecase.track;

import com.mind.runner.business.entity.Track;
import com.mind.runner.business.port.TrackRepository;

import java.util.List;
import java.util.Optional;

/**
 * Find track user story
 */

public class FindTrack {

    private final TrackRepository trackRepository;

    public FindTrack(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Optional<Track> findById(Long id) {
        return trackRepository.findById(id);
    }

    public List<Track> findAll() {
        return trackRepository.findAll();
    }

}