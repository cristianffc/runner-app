package com.mind.runner.adapter.outbound.jpa.entity;

import com.mind.runner.business.entity.Track;
import com.mind.runner.business.entity.enums.Surface;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Track")
public class TrackJpaEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String name;
    private Integer size;
    private Surface surface;
    private String country;
    private String city;
    private String address;
    private Date createdAt;

    public TrackJpaEntity() {}

    public TrackJpaEntity(String id, String name, Integer size, Surface surface, String country, String city,
                          String address, Date createdAt) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.surface = surface;
        this.country = country;
        this.city = city;
        this.address = address;
        this.createdAt = createdAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Track trackBuilder() {
        return Track.builder().
                withId(id).
                withAddress(address).
                withCity(city).
                withName(name).
                withSurface(surface).
                withSize(size).
                withCreatedAt(createdAt).
                build();
    }

    public static TrackJpaEntity trackJpaEntityBuilder(Track track) {
        var trackJpaEntity = new TrackJpaEntity();

        trackJpaEntity.setId(track.getId());
        trackJpaEntity.setAddress(track.getAddress());
        trackJpaEntity.setCity(track.getCity());
        trackJpaEntity.setCountry(track.getCountry());
        trackJpaEntity.setCreatedAt(track.getCreatedAt());
        trackJpaEntity.setName(track.getName());
        trackJpaEntity.setSize(track.getSize());
        trackJpaEntity.setSurface(track.getSurface());

        return trackJpaEntity;
    }
}