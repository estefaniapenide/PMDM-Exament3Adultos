package com.example.penide_estefania_examen3t

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.penide_estefania_examen3t.databinding.ElementoAzulBinding
import com.google.android.material.snackbar.Snackbar


class CustomAdapter(private val listaDiscos:MutableList<Disco>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(binding: ElementoAzulBinding): RecyclerView.ViewHolder(binding.root) {
        val elemento = binding.root
        val titulo = binding.tvTitulo
        val autor = binding.tvAutor
        val caratula = binding.imageViewCaratula


        init {
            elemento.setOnClickListener{}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ElementoAzulBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

    )




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.titulo.text = listaDiscos[position].titulo
        holder.autor.text = listaDiscos[position].autor
        holder.caratula.setImageResource(listaDiscos[position].caratula)
        val idCaratula =listaDiscos[position].caratula
        val info=listaDiscos[position].descripcion
        val id = listaDiscos[position].id

        holder.elemento.setOnClickListener {
            it.findNavController().navigate(ListadoAlbumsFragmentDirections.actionListadoAlbumsFragmentToInformacionFragment(holder.titulo.text.toString(),holder.autor.text.toString(),info,idCaratula,id))
        }

        if (listaDiscos.size == 0) {
            Snackbar.make(holder as View, "No hay discos en la selcción actual", Snackbar.LENGTH_LONG).setAction("Volver",
                View.OnClickListener {
                    it.findNavController()
                        .navigate(ListadoAlbumsFragmentDirections.actionListadoAlbumsFragmentToBiblioMusicaFragment())
                }).show()
        }



        /*if(idEliminar==id){
            listaDiscos.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listaDiscos.size)
        }*/
    }

    override fun getItemCount(): Int {
        return listaDiscos.size
    }
}

/*class CustomAdapter(private val onClick: (Album) -> Unit) :
    ListAdapter<Album, CustomAdapter.AlbumViewHolder>(AlbumDiffCallback) {

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class AlbumViewHolder(binding: ElementoAzulBinding, val onClick: (Album) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        private val AlbumTitulo = binding.tvTitulo
        private val AlbumAutor = binding.tvAutor
        private val AlbumCaratula = binding.imageViewCaratula
        private var currentAlbum: Album? = null

        init {
            binding.root.setOnClickListener {
                currentAlbum?.let {
                    onClick(it)
                }
            }
        }

        /* Bind flower name and image. */
        fun bind(album: Album) {
            currentAlbum = album
            AlbumTitulo.text = album.titulo
            AlbumAutor.text=album.autor
            AlbumCaratula.setImageResource(album.caratula ?: IMAGE_NO_AVALIABLE_RESOURCE)
        }
    }

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumViewHolder(
        ElementoAzulBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick
    )

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

    }
}

object AlbumDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }
}*/

