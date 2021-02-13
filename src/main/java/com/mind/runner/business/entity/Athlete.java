package com.mind.runner.business.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Value
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Athlete {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String email;
    private Date birth;
    private Date createdAt;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}