package com.mind.runner.business.usecase.track;

import com.mind.runner.business.port.TrackRepository;

/**
 * Delete athlete user story
 */

public class DeleteTrack {

    private final TrackRepository trackRepository;

    public DeleteTrack(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void delete(Long id) {
        trackRepository.deleteById(id);
    }
}
