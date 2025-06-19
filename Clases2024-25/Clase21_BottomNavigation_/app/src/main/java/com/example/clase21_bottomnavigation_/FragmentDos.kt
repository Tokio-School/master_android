package com.example.clase21_bottomnavigation_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clase21_bottomnavigation_.databinding.FragmentDosBinding
import com.example.clase21_bottomnavigation_.databinding.FragmentUnoBinding


class FragmentDos : Fragment() {
    lateinit var binding: FragmentDosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("dato", this) { requestKey, bundle ->
            val datoRecibido = bundle.getString("dato")
            binding.tvDatoRecibido.text = datoRecibido ?: "No se recibió ningún dato"
        }




    }
}