package com.example.clase15_activity_actionbarjava;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioParcelable implements Parcelable {

    private String nombre;

    protected UsuarioParcelable(Parcel in) {
        nombre = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UsuarioParcelable> CREATOR = new Creator<UsuarioParcelable>() {
        @Override
        public UsuarioParcelable createFromParcel(Parcel in) {
            return new UsuarioParcelable(in);
        }

        @Override
        public UsuarioParcelable[] newArray(int size) {
            return new UsuarioParcelable[size];
        }
    };
}
