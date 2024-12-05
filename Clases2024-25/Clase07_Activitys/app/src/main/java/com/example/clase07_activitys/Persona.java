package com.example.clase07_activitys;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Persona implements Parcelable { //Serializable {
    private String nombre;
    private String contrasena;

    public Persona(String nombre, String contrasena) {

        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        contrasena = in.readString();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(contrasena);
    }
}
