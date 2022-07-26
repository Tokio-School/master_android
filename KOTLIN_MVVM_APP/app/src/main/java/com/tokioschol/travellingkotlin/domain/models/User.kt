package com.tokioschol.travellingkotlin.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name:String, val surName:String, val age:Int): Parcelable
