package com.example.clase13_databinding;

public class Persona {
    private String nombre;
    private String ciudadNacimiento;
    private String telefono;
    private boolean soltero;

    public boolean isSoltero() {
        return soltero;
    }

    public void setSoltero(boolean soltero) {
        this.soltero = soltero;
    }

    public Persona(String nombre, String ciudadNacimiento, String telefono) {
        this.nombre = nombre;
        this.ciudadNacimiento = ciudadNacimiento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
