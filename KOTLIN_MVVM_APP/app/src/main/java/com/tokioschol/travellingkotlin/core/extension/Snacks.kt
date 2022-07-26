package com.tokioschol.travellingkotlin.core.extension

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.tokioschol.travellingkotlin.domain.models.SnackbarMessage

fun Fragment.snack(snackMessage: SnackbarMessage): Snackbar {
    val timeSnack = if (snackMessage.shortDuration) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    return Snackbar.make(this.requireView(), getMessageResource(snackMessage, this), timeSnack)
}

private fun getMessageResource(snackMessage: SnackbarMessage, fragment: Fragment): String {
    return when {
        snackMessage.message != null -> snackMessage.message
        snackMessage.varargs != null -> fragment.context?.getString(snackMessage.messageId, snackMessage.varargs)
        else -> fragment.context?.getString(snackMessage.messageId)
    } ?: ""
}