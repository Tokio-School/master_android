package com.tokioschol.tp8_viewbinding_databinding.databinding.modelui;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.tokioschol.tp8_viewbinding_databinding.BR;

public class EjemploDosDirecciones extends BaseObservable {

    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(!this.text.equals(text)){
            this.text = text;
            notifyPropertyChanged(BR.text);
        }
    }
}
