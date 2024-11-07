package com.example.clase05_viewbindingdatabinding;

public class Usuario {
    private String nombre;
    private int edad;

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

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
       /* return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';*/
        return nombre;
    }
}



