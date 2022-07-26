package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingStepThreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingStepThreeFragment: Fragment() {

    private lateinit var dataBinding: FragmentOnboardingStepThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = FragmentOnboardingStepThreeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@OnboardingStepThreeFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener = EventClickListenersOnboarding(findNavController())
    }
}