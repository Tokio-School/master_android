package dev.amrv.ejer.Clase09_Practicando_TouchListener;

public class Persona {
    private final String nombre;
    private final String edad;
    private final String ciudad;

    public Persona(String nombre, String edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
