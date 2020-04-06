package com.mind.runner.business.entity;

import com.mind.runner.business.entity.enums.TrackType;

public class Track {

    private String id;
    private String name;
    private Integer size;
    private TrackType trackType;

    public Track() {}

    public Track(String id, String name, Integer size, TrackType trackType) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.trackType = trackType;
    }

    public static TrackBuilder builder() {
        return new TrackBuilder();
    }

    public static class TrackBuilder {
        private String id;
        private String name;
        private Integer size;
        private TrackType trackType;

        public TrackBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public TrackBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TrackBuilder withSize(Integer size) {
            this.size = size;
            return this;
        }

        public TrackBuilder withTrackTyoe(TrackType trackType) {
            this.trackType = trackType;
            return this;
        }

        public Track build() {
            return new Track(id, name, size, trackType);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public TrackType getTrackType() {
        return trackType;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", trackType=" + trackType +
                '}';
    }

}
