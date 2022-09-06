package com.example.penide_estefania_examen3t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.example.penide_estefania_examen3t.databinding.FragmentListadoAlbumsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListadoAlbumsFragment : Fragment() {

    private var _binding: FragmentListadoAlbumsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListadoAlbumsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listadoDiscos:MutableList<Disco> = ArrayList()

        var genero = ListadoAlbumsFragmentArgs.fromBundle(requireArguments()).genero

        val listas : DataDisco by navGraphViewModels<DataDisco>(R.id.nav_graph) {
            defaultViewModelProviderFactory
        }

        /*when(genero){
            "rock" ->listadoDiscos.addAll(listas.listaDiscos.value.addAll(listas.listadoRock))
            "blues" ->listadoDiscos.addAll(listas.listadoBlues)
            "jazz" -> listadoDiscos.addAll(listas.listadoJazz)
        }*/

        when(genero){
            "rock" ->listadoDiscos.addAll(listas.listadoRock)
            "blues" ->listadoDiscos.addAll(listas.listadoBlues)
            "jazz" -> listadoDiscos.addAll(listas.listadoJazz)
        }


        binding.recyclerView
            .apply{adapter= CustomAdapter(listadoDiscos)}


        /*val AlbumsAdapter = CustomAdapter { Album -> adapterOnClick(album) }

        binding.recyclerView.apply {
            adapter = ConcatAdapter(headerAdapter, AlbumsAdapter)
        }

        flowersListViewModel.flowersLiveData.observe(viewLifecycleOwner) {
            it?.let {
                flowersAdapter.submitList(it)
                headerAdapter.updateFlowerCount(it.size)
            }
        }

        binding.fab.setOnClickListener {
            fabOnClick()
        }

    }

    /* Opens FlowerDetailActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(flower: Flower) = findNavController().navigate(
        FlowerListFragmentDirections.actionToFlowerDetailFragment(flower.id))


    /* Adds flower to flowerList when FAB is clicked. */
    private fun fabOnClick() = findNavController().navigate(
        FlowerListFragmentDirections.actionToAddFlowerFragment())*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}