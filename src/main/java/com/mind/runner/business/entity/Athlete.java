package com.mind.runner.business.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Athlete {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birth;
    private Date createdAt;

    public Athlete() {}

    private Athlete(Long id, String firstName, String lastName, String email, Date birth,
                    Date createAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
        this.createdAt = createAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static AthleteBuilder builder() {
        return new AthleteBuilder();
    }

    public static class AthleteBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Date birth;
        private Date createdAt;

        public AthleteBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AthleteBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AthleteBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AthleteBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AthleteBuilder withBirth(Date birth) {
            this.birth = birth;
            return this;
        }

        public AthleteBuilder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Athlete build() {
            return new Athlete(id, firstName, lastName, email, birth, createdAt);
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}