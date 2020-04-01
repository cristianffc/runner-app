package com.mind.runner.business.entity;

public class Athlete {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Integer age;
    private String goal;

    public Athlete() {}

    private Athlete(Long id, String firstName, String lastName, String password, String email, Integer age, String goal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.goal = goal;
    }

    public static AthleteBuilder builder() {
        return new AthleteBuilder();
    }

    public static class AthleteBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Integer age;
        private String goal;

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

        public AthleteBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AthleteBuilder withEmail(String email) {
            this.email = email;
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

        public Athlete build() {
            return new Athlete(id, firstName, lastName, password, email, age, goal);
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

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", goal='" + goal + '\'' +
                '}';
    }
}
