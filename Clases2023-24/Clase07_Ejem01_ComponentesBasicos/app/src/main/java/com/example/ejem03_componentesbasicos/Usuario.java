package com.example.ejem03_componentesbasicos;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String estadoCivil;
    private String ciudad;
    private ArrayList<String> deportes =new ArrayList<>();

    public Usuario(String nombre, String estadoCivil, String ciudad, ArrayList<String> deportes) {
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
        this.deportes = deportes;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(ArrayList<String> deportes) {
        this.deportes = deportes;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
