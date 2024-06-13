package com.example.prietonoel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prietonoel.databinding.FragmentUsuariosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentUsuarios.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentUsuarios : Fragment() {
    private var param1: String? = null
    private var param2: Int? = null
    private var param3: String? = null

    lateinit var binding: FragmentUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsuariosBinding.inflate(inflater, container, false)
        if(!param1.isNullOrBlank()) {
            binding.user = Usuario(param1!!, param2!!, param3!!)
        }
        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int, param3: String) =
            FragmentUsuarios().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                }
            }
    }




}