package com.mind.runner.adapter.inbound.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mind.runner.business.entity.Track;
import com.mind.runner.business.entity.enums.Surface;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

public class TrackDto extends RepresentationModel<TrackDto> {

    private String id;
    private String name;
    private Integer size;
    private Surface surface;
    private String country;
    private String city;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date createdAt;

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

    public static TrackDto trackDtoBuilder(Track track) {
        var TrackDto = new TrackDto();

        TrackDto.setId(track.getId());
        TrackDto.setAddress(track.getAddress());
        TrackDto.setCity(track.getCity());
        TrackDto.setCountry(track.getCountry());
        TrackDto.setCreatedAt(track.getCreatedAt());
        TrackDto.setSize(track.getSize());
        TrackDto.setName(track.getName());
        TrackDto.setSurface(track.getSurface());

        return TrackDto;
    }
}