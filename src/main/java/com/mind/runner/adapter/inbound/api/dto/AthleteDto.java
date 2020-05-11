package com.mind.runner.adapter.inbound.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mind.runner.business.entity.Athlete;
import org.springframework.hateoas.RepresentationModel;
import java.util.Date;

public class AthleteDto extends RepresentationModel<AthleteDto> {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String goal;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static AthleteDto toAthleteDto(Athlete athlete) {
        var AthleteDto = new AthleteDto();

        AthleteDto.setId(athlete.getId());
        AthleteDto.setFirstName(athlete.getFirstName());
        AthleteDto.setLastName(athlete.getLastName());
        AthleteDto.setAge(athlete.getAge());
        AthleteDto.setGoal(athlete.getGoal());
        AthleteDto.setCreatedAt(athlete.getCreatedAt());

        return AthleteDto;
    }

}
