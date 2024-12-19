package com.example.clase08_recyclerview;

import android.graphics.drawable.Drawable;

public class Persona {
    private String nombre;
    private int edad;
    private String email;
    private Drawable imagen;

    public Persona(String nombre, int edad, String email, Drawable imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
