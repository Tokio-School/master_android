package com.example.clase10_permisosViewmodel;

public class Contador {
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public Contador(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "numero=" + numero +
                '}';
    }
    public void incrementar(){
        numero++;
    }
}
