package com.tokioschol.travellingkotlin.domain.models

data class SnackbarMessage(
    /** Resource string ID of the message to show */
    val messageId: Int = -1,

    /** Resource string of the message to show */
    val message: String? = null,

    /** Optional resource string ID for the action (example: "Got it!") */
    val actionId: Int? = null,

    /** Set to true for a Snackbar with short duration  */
    val shortDuration: Boolean = false,

    /** Params for resource string */
    val varargs: String? = null,

    )
