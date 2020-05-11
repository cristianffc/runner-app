package com.mind.runner.business.entity;

import java.util.Date;

public class Athlete {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String goal;
    private Date createdAt;

    public Athlete() {}

    private Athlete(Long id, String firstName, String lastName, Integer age, String goal, Date createAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.goal = goal;
        this.createdAt = createAt;
    }

    public static AthleteBuilder builder() {
        return new AthleteBuilder();
    }

    public static class AthleteBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String goal;
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

        public AthleteBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public AthleteBuilder withGoal(String goal) {
            this.goal = goal;
            return this;
        }

        public AthleteBuilder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Athlete build() {
            return new Athlete(id, firstName, lastName, age, goal, createdAt);
        }
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

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
