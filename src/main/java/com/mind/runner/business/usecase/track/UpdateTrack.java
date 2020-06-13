package com.mind.runner.business.usecase.track;

import com.mind.runner.business.entity.Track;
import com.mind.runner.business.port.TrackRepository;

import java.util.Optional;

/**
 * Update athlete user story
 */

public class UpdateTrack {

    private final TrackRepository trackRepository;

    public UpdateTrack(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Optional<Track> updateIdempotent(Long id, Track newTrack) {
        Optional<Track> track = trackRepository.findById(id);
        if (track.isPresent()) {
            newTrack.setId(track.get().getId());
            return Optional.of(trackRepository.update(newTrack));
        }
        return track;
    }

    public Optional<Track> update(Long id, Track newTrack) {
        Optional<Track> track = trackRepository.findById(id);
        if(track.isPresent()) {
            if (newTrack.getAddress() != null) {
                track.get().setAddress(newTrack.getAddress());
            }
            if (newTrack.getCity() != null) {
                track.get().setCity(newTrack.getCity());
            }
            if (newTrack.getCountry() != null) {
                track.get().setCountry(newTrack.getCountry());
            }
            if (newTrack.getName() != null) {
                track.get().setName(newTrack.getName());
            }
            if (newTrack.getSize() != null) {
                track.get().setSize(newTrack.getSize());
            }
            return Optional.of(trackRepository.update(track.get()));
        }
        return track;
    }
}