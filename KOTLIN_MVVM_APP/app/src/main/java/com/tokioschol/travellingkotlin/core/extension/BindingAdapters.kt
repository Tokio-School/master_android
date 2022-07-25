package com.tokioschol.travellingkotlin.core.extension


import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tokioschol.travellingkotlin.core.base.glide.GlideApp

@BindingAdapter("loadImage","placeHolder")
fun AppCompatImageView.loadImage(profileImage: String?,placeHolderType: Drawable?) {
    profileImage?.let {
        GlideApp.with(this)
            .load(profileImage)
            .defaultOptions(placeHolderType)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}