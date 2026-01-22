package com.example.clase10_permisosViewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorViewmodel extends ViewModel {

    private MutableLiveData<Integer> numero= new MutableLiveData<Integer>(0);

    public MutableLiveData<Integer> getNumero() {
        return numero;
    }

    public void setNumero(MutableLiveData<Integer> numero) {
        this.numero = numero;
    }
    public void incrementar(){
        numero.setValue(numero.getValue()+1);
    }
}
