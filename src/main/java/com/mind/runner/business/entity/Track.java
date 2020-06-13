package com.mind.runner.business.entity;

import com.mind.runner.business.entity.enums.Surface;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Track {

    private String id;
    private String name;
    private Integer size;
    private Surface surface;
    private String country;
    private String city;
    private String address;

    public Track() {}

    public Track(String id, String name, Integer size, Surface surface, String country, String city, String address) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.surface = surface;
        this.country = country;
        this.city = city;
        this.address = address;
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

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static TrackBuilder builder() {
        return new TrackBuilder();
    }

    public static class TrackBuilder {

        private String id;
        private String name;
        private Integer size;
        private Surface surface;
        private String country;
        private String city;
        private String address;

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
        public TrackBuilder withSurface(Integer size) {
            this.size = size;
            return this;
        }

        public TrackBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public TrackBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public TrackBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Track build() {
            return new Track(id, name, size, surface, country, city, address);
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}