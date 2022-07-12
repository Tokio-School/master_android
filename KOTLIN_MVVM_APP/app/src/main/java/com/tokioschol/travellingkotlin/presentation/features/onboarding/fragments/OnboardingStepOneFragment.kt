package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingStepOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingStepOneFragment:Fragment() {
    private lateinit var dataBinding: FragmentOnboardingStepOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = FragmentOnboardingStepOneBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@OnboardingStepOneFragment
        }
        return dataBinding.root
    }
}