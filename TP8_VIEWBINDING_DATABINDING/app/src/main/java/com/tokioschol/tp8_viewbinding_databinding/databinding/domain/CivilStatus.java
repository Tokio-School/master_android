package com.tokioschol.tp8_viewbinding_databinding.databinding.domain;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({CivilStatus.SINGLE, CivilStatus.MARRIED, CivilStatus.DIVORCED})
public @interface CivilStatus {
    int SINGLE = 0;
    int MARRIED = 1;
    int DIVORCED = 2;
}



