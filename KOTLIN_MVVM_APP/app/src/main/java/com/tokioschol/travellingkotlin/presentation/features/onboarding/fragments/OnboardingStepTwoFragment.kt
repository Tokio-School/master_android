package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingContainerBinding
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingStepOneBinding
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingStepTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingStepTwoFragment: Fragment() {

    private lateinit var dataBinding: FragmentOnboardingStepTwoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = FragmentOnboardingStepTwoBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@OnboardingStepTwoFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener = EventClickListenersOnboarding(findNavController())

    }
}