package com.mind.runner.adapter.inbound.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.entity.enums.Objective;
import org.springframework.hateoas.RepresentationModel;
import java.util.Date;

public class AthleteDto extends RepresentationModel<AthleteDto> {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date birth;
    private String email;
    private Objective objective;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static AthleteDto athleteDtoBuilder(Athlete athlete) {
        var AthleteDto = new AthleteDto();

        AthleteDto.setId(athlete.getId());
        AthleteDto.setFirstName(athlete.getFirstName());
        AthleteDto.setLastName(athlete.getLastName());
        AthleteDto.setBirth(athlete.getBirth());
        AthleteDto.setObjective(athlete.getObjective());
        AthleteDto.setEmail(athlete.getEmail());
        AthleteDto.setCreatedAt(athlete.getCreatedAt());

        return AthleteDto;
    }
}