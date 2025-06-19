package com.example.clase21_bottomnavigation_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clase21_bottomnavigation_.databinding.FragmentUnoBinding

class FragmentUno : Fragment() {

    lateinit var binding: FragmentUnoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUnoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bEnviarInformacion.setOnClickListener {
            val texto = binding.tietDato.text.toString()
            val bundle = Bundle()
            bundle.putString("dato", texto)

            parentFragmentManager.setFragmentResult("dato", bundle)
        }
    }



}