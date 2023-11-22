package com.example.clase11_constraintlayoutj;

import androidx.annotation.NonNull;

public class Producto {
    private String nombre;
    private Double precio = 0.0;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
