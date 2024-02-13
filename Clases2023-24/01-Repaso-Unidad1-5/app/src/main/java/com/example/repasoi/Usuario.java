package com.example.repasoi;

public class Usuario {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public Usuario() {

    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
