package com.example.retrofit;

public class Lenguaje {
    private String code;
    private String name;

    public Lenguaje(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public Lenguaje() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lenguaje{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
