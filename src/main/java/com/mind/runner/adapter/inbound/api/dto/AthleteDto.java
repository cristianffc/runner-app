package com.mind.runner.adapter.inbound.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mind.runner.business.entity.Athlete;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class AthleteDto extends RepresentationModel<AthleteDto> {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date birth;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date createdAt;

    public static AthleteDto athleteDtoBuilder(final Athlete athlete) {
        final var AthleteDto = new AthleteDto();

        AthleteDto.setId(athlete.getId());
        AthleteDto.setFirstName(athlete.getFirstName());
        AthleteDto.setLastName(athlete.getLastName());
        AthleteDto.setBirth(athlete.getBirth());
        AthleteDto.setEmail(athlete.getEmail());
        AthleteDto.setCreatedAt(athlete.getCreatedAt());

        return AthleteDto;
    }
}