package com.mind.runner.business.entity;

public class Trainer {

    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Integer age;
    private String skill;

    public Trainer() {}

    public Trainer(String id, String firstName, String lastName, String password, String email, Integer age, String skill) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.skill = skill;
    }

    public static TrainerBuilder builder() {
        return new TrainerBuilder();
    }

    public static class TrainerBuilder {

        private String id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Integer age;
        private String skill;

        public TrainerBuilder withId(String id) {
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

        public TrainerBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public TrainerBuilder withSkill(String skill) {
            this.skill = skill;
            return this;
        }

        public Trainer build() {
            return new Trainer(id, firstName, lastName, password, email, age, skill);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }

}