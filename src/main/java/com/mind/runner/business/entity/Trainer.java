package com.mind.runner.business.entity;

import com.mind.runner.business.entity.enums.Specialty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Trainer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birth;
    private Specialty specialty;
    private Date createdAt;

    public Trainer() {}

    public Trainer(Long id, String firstName, String lastName, String email, Date birth, Specialty specialty,
                   Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
        this.specialty = specialty;
        this.createdAt = createdAt;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static TrainerBuilder builder() {
        return new TrainerBuilder();
    }

    public static class TrainerBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Date birth;
        private Specialty specialty;
        private Date createdAt;

        public TrainerBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TrainerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TrainerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TrainerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public TrainerBuilder withBirth(Date birth) {
            this.birth = birth;
            return this;
        }

        public TrainerBuilder withSpecialty(Specialty specialty) {
            this.specialty = specialty;
            return this;
        }

        public TrainerBuilder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Trainer build() {
            return new Trainer(id, firstName, lastName, email, birth, specialty, createdAt);
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}