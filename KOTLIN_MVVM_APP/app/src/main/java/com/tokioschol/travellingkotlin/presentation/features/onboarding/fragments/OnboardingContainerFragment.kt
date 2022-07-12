package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tokioschol.travellingkotlin.databinding.FragmentOnboardingContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingContainerFragment: Fragment() {

    private lateinit var dataBinding: FragmentOnboardingContainerBinding

    private val adapter by lazy {
        OnboardingAdapter(childFragmentManager,lifecycle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = FragmentOnboardingContainerBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@OnboardingContainerFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.onboardingVp.adapter = adapter
        dataBinding.onboardingVp.setPageTransformer(TransformationPage())
    }
}