package com.tokioschol.tp8_viewbinding_databinding.databinding.domain;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({Gender.MALE, Gender.FEMALE})
public @interface Gender {
    int MALE = 0;
    int FEMALE = 1;
}



