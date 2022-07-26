package com.tokioschol.travellingkotlin.core.base.glide

import android.graphics.drawable.Drawable
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.BaseRequestOptions


@GlideExtension
object GlideExtension {

    @GlideOption
    @JvmStatic
    fun defaultOptions(options: BaseRequestOptions<*>,placeHolder: Drawable?):BaseRequestOptions<*> {
        return options
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .centerCrop()
            .error(placeHolder)
    }
}