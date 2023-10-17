package com.example.clase05_ejem02_spinner;

import androidx.annotation.NonNull;

public class Usuario
{
    //POJO
    private String nombre;
    private int edad;
    private boolean casado;

    public Usuario() {
    }
    public Usuario(String nombre, int edad, boolean casado) {
        this.nombre = nombre;
        this.edad = edad;
        this.casado = casado;
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
    public boolean isCasado() {
        return casado;
    }
    public void setCasado(boolean casado) {
        this.casado = casado;
    }
    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
