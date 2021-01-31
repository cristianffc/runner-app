package com.mind.runner.business.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

@Value
@Builder(setterPrefix = "with")
public class Athlete {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birth;
    private Date createdAt;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}