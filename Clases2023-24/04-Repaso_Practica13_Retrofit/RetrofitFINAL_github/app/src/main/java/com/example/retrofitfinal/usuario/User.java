package com.example.retrofitfinal.usuario;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", userToken='" + userToken + '\'' +
                ", idBdReference=" + idBdReference +
                '}';
    }

    @SerializedName("nombre")
    private String name;

    private String lastname;


    private String ageGroup;


    private String password;

    @SerializedName("edad")
    private int age;

    @SerializedName("genero")
    private int gender;

    @SerializedName("userToken")
    private String userToken;

    @SerializedName("idBdReference")
    private int idBdReference;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getIdBdReference() {
        return idBdReference;
    }

    public void setIdBdReference(int idBdReference) {
        this.idBdReference = idBdReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.lastname);
        dest.writeString(this.ageGroup);
        dest.writeString(this.password);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.lastname = source.readString();
        this.ageGroup = source.readString();
        this.password = source.readString();
    }

    public User() {
        //Empty Constructor
    }

    public User(String name, String lastname, String ageGroup, String password) {
        this.name = name;
        this.lastname = lastname;
        this.ageGroup = ageGroup;
        this.password = password;
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.lastname = in.readString();
        this.ageGroup = in.readString();
        this.password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
