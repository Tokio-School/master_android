package com.tokioschol.tp8_viewbinding_databinding.databinding.domain;

public class UserModel {
    private String name;
    private String lastName;
    private int age;
    private @Gender int gender;
    private @CivilStatus int civilState;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Gender
    public int getGender() {
        return gender;
    }

    public void setGender(@Gender int gender) {
        this.gender = gender;
    }

    @CivilStatus
    public int getCivilState() {
        return civilState;
    }

    public void setCivilState(@CivilStatus int civilState) {
        this.civilState = civilState;
    }
}
