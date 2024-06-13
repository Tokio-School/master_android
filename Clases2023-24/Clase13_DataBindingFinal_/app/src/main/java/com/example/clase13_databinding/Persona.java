package com.example.clase13_databinding;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int edad;
    private boolean soltero;

    private ArrayList<String> listaDeportes;

    public ArrayList<String> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(ArrayList<String> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public Persona(String nombre, int edad, boolean soltero) {
        this.nombre = nombre;
        this.soltero = soltero;
        this.edad=edad;
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

    public boolean isSoltero() {
        return soltero;
    }

    public void setSoltero(boolean soltero) {
        this.soltero = soltero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", soltero=" + soltero +
                '}';
    }
}
