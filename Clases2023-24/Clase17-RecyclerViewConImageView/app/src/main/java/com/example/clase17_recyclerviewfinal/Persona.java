package com.example.clase17_recyclerviewfinal;

import android.graphics.drawable.Drawable;

public class Persona {
    private int edad;
    private String nombre;
    private String telefono;
    private Drawable imagen;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public Persona(int edad, String nombre, String telefono, Drawable imagen) {
        this.edad = edad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public Persona() {

    }
    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}
