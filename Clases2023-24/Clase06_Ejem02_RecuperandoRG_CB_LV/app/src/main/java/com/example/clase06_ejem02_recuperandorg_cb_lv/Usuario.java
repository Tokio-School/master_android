package com.example.clase06_ejem02_recuperandorg_cb_lv;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String ciudad;
    private boolean casado;
    private String profesion;
    private ArrayList<String> deportes;

    public Usuario(String nombre, String ciudad, boolean casado, String profesion, ArrayList<String> deportes) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.casado = casado;
        this.profesion = profesion;
        this.deportes = deportes;
    }

    public Usuario() {
    }

    @Override
   /* public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", casado=" + casado +
                ", profesion='" + profesion + '\'' +
                ", deportes='" +  + '\'' +
                '}';
    }*/
    public String toString() {
        return nombre;
    }
}
