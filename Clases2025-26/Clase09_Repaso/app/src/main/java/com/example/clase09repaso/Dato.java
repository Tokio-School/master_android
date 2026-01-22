package com.example.clase09repaso;

public class Dato {
    String nombre;
    int edad;

    public Dato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Dato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        /*return "Dato{" +
                "nombre='" + nombre + '\'' +
                '}';*/
       return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
