package com.tokioschol.miprimeraappkotlin

import android.view.View
import java.util.*

fun View.showOrGone(condition:Boolean){
    when(condition){
        true -> this.visibility = View.VISIBLE
        false -> this.visibility = View.GONE
    }
}


fun String.isEmail():Boolean{
    //regex
    true
}