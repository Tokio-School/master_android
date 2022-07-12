package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import androidx.navigation.NavController
import com.tokioschol.travellingkotlin.R

class EventClickListenersOnboarding(private val navController: NavController) {

    fun navigateLogin(){
        navController.navigate(R.id.to_loginFragment)
    }
}