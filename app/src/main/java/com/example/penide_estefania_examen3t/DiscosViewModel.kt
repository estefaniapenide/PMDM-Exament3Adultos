package com.example.penide_estefania_examen3t

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.penide_estefania_examen3t.DataSource

class DiscosViewModel(val dataSource: DataSource) : ViewModel() {

    val AlbumsLiveData = MutableLiveData(dataSource.AlbumList)

    fun addAlbum(album:Album) {
        dataSource.addAlbum(dataSource.newAlbumIndexing(album.titulo, album.autor,album.caratula, album.descripcion))
        updateLiveData()
    }

    fun removeAlbum(album: Album) {
        dataSource.removeAlbum(album)
        updateLiveData()
    }

    private fun updateLiveData() {
        AlbumsLiveData.value = dataSource.AlbumList
    }

    fun getAlbumFromId(id: Long): Album? {
        return dataSource.getAlbumFromId(id)  // TODO: Leemos directamente del modelo, no del LiveData
    }



}

class DiscosViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiscosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiscosViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}