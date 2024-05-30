package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public enum HealthState {
        GOOD_HEALTH("Добре здоров'я", 1),
        INJURY("Травма",2),
        DIGESTIVE_UPSET("Розлад травлення",3),
        RESPIRATORY_INFECTION("Респіраторна інфекція",4),
        SKIN_IRRITATION("Подразнення шкіри",5),
        CHRONIC_CONDITION("Хронічний стан", 6),
        EMERGENCY("Надзвичайна ситуація",7);

        private final String ukrTranslation;
        private final int value;

        HealthState(String ukrTranslation, int value) {
            this.ukrTranslation = ukrTranslation;
            this.value = value;
        }

        public String getUkrTranslation() {
            return ukrTranslation;
        }
        public int getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "Pet {"
                + "\n\t\ttype = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", health state = " + healthState.getUkrTranslation()
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "\n\t}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
