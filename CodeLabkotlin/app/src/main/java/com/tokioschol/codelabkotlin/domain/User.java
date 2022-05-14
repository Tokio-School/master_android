package com.tokioschol.codelabkotlin.domain;

public class User {
    private String composeName;
    private int age;

    public User(String composeName, int age) {
        this.composeName = composeName;
        this.age = age;
    }

    public String getComposeName() {
        return composeName;
    }

    public int getAge() {
        return age;
    }
}
