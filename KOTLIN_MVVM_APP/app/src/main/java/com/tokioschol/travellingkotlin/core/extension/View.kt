package com.tokioschol.travellingkotlin.core.extension

import android.view.View

fun View.showOrGone(value : Boolean){
    if(value){
        this.show()
    }else{
        this.gone()
    }
}

/**
 * Show the view  (visibility = View.VISIBLE)
 */
fun View.show() : View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

/**
 * Hide the view  (visibility = View.VISIBLE)
 */
fun View.gone() : View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}