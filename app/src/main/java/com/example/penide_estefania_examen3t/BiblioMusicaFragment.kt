package com.example.penide_estefania_examen3t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.penide_estefania_examen3t.databinding.FragmentBiblioMusicaBinding

class BiblioMusicaFragment : Fragment() {

    private var _binding: FragmentBiblioMusicaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBiblioMusicaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinner
            .apply{setSelection(0,false)}
            .apply{adapter= ArrayAdapter.createFromResource(requireContext(),R.array.generos,R.layout.elemento).apply{setDropDownViewResource(R.layout.elemento_amarillo)}}
            .apply {
                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        when(position){
                            0->binding.buttonIr.visibility=View.INVISIBLE
                            1-> binding.buttonIr.visibility=View.VISIBLE
                            2-> binding.buttonIr.visibility=View.VISIBLE
                            3 -> binding.buttonIr.visibility=View.VISIBLE
                        }
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }

        binding.buttonIr.setOnClickListener {
            findNavController().navigate(
                when(binding.spinner.selectedItemPosition){
                    1 -> {BiblioMusicaFragmentDirections.actionBiblioMusicaFragmentToListadoAlbumsFragment("rock")}//añadir paso por argumentos si no sale el viewmodel
                    2 -> {BiblioMusicaFragmentDirections.actionBiblioMusicaFragmentToListadoAlbumsFragment("blues")}
                    3 -> {BiblioMusicaFragmentDirections.actionBiblioMusicaFragmentToListadoAlbumsFragment("jazz")}
                    else -> throw Exception("Excepción")
                }
            )
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}