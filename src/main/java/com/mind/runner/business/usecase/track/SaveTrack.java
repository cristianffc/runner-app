package com.mind.runner.business.usecase.track;

import com.mind.runner.business.entity.Track;
import com.mind.runner.business.port.TrackRepository;

/*
 * Save athlete user story
 */

public class SaveTrack {

    private final TrackRepository trackRepository;

    public SaveTrack(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track save(Track athlete){
        return trackRepository.save(athlete);
    }
}