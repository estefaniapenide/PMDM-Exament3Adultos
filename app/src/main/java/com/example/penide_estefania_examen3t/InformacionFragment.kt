package com.example.penide_estefania_examen3t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.penide_estefania_examen3t.databinding.FragmentInformacionBinding


class InformacionFragment : Fragment() {

    private var _binding: FragmentInformacionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInformacionBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val AlbumsViewModel by activityViewModels<DiscosViewModel> {
        DiscosViewModelFactory(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var titulo = InformacionFragmentArgs.fromBundle(requireArguments()).titulo
        var autor = InformacionFragmentArgs.fromBundle(requireArguments()).autor
        var descripcion =InformacionFragmentArgs.fromBundle(requireArguments()).descripcion
        var idCaratula =InformacionFragmentArgs.fromBundle(requireArguments()).idCaratula
        var id =InformacionFragmentArgs.fromBundle(requireArguments()).id

        binding.tituloAutor.text="${titulo} - ${autor}"
        binding.descripcion.text=descripcion
        binding.caratula.setImageResource(idCaratula)

        binding.buttonEliminar.setOnClickListener {
            findNavController().navigate(InformacionFragmentDirections.actionInformacionFragmentToListadoAlbumsFragment())
        }

        /*AlbumsViewModel.getAlbumFromId(
            InformacionFragmentArgs.fromBundle(requireArguments()).albumid
        )?.let { album ->
            binding.tituloAutor.text = "${album.titulo} - ${album.autor}"
            binding.caratula.setImageResource(album.caratula ?: IMAGE_NO_AVALIABLE_RESOURCE)
            binding.descripcion.text = album.descripcion.toString()//Arreglar esto que solo recibe el int id del string

            binding.buttonEliminar.setOnClickListener {
                AlbumsViewModel.removeAlbum(album)
                findNavController().navigate(InformacionFragmentDirections.actionInformacionFragmentToListadoAlbumsFragment())
            }

        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}