package com.example.penide_estefania_examen3t

import android.app.Application
import android.content.res.Resources

//...




/*class Album(val id: Int, val titulo: String, val autor: String, val imageRes: Int?, val descRes: Int) {
    enum class Genero { Rock, Blues, Jazz }

//...

}*/


val IMAGE_NO_AVALIABLE_RESOURCE = R.drawable.disco


class DataSource(resources: Resources) {


    /* Esta clase será un singleton, pero como requerimos que reciba el contexto como
    parámetro, no podemos simplemente crear un object. */
    companion object {
        @Volatile
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    /*object dataSource {
        var listaRock = getListadoRock()
        var listaBlues = getListadoBlues()
        var listaJazz = getListadoJazz()

    }*/

    var AlbumList = getListadoRock().toMutableList() //Ver cómo solucionar esto para hacerlo con todos


    fun addAlbum(album: Album) {
       AlbumList.add(0, album)
    }

    fun removeAlbum(album: Album) {
        AlbumList.remove(album)
    }

    fun getAlbumFromId(id: Long) = AlbumList.firstOrNull { it.id == id }


    private var idIndex = 1L

    fun newAlbumIndexing(titulo: String, autor: String,image: Int, description: Int) =
        Album(++idIndex, titulo, autor, image, description)


    fun getListadoRock() = mutableListOf(
        newAlbumIndexing("Abbey Road", "The Beatles", R.drawable.abbeyroad, R.string.abbeyroad),
        newAlbumIndexing("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst, R.string.exilesonmainstreet),
        newAlbumIndexing("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground, R.string.velvetunderground),
        newAlbumIndexing("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,  R.string.areyouexperienced),
        newAlbumIndexing("Back in Black", "AC/DC", R.drawable.backinblack,  R.string.backinblack),
        newAlbumIndexing("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,  R.string.appetitefordestruction),
        newAlbumIndexing("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,  R.string.ledzeppeliniv)
    )

    fun getListadoBlues() = mutableListOf(
        newAlbumIndexing("Lady Soul", "Aretha Franklin", R.drawable.ladysoul,  R.string.ladysoul),
        newAlbumIndexing("I Never Loved a Man the Way I Love You", "Aretha Franklin",  R.drawable.neverloved, R.string.ineverloveda),
        newAlbumIndexing("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,R.string.whatsgoingon)
    )

    fun getListadoJazz() = mutableListOf(
        newAlbumIndexing("Kind of Blue", "Miles Davis", R.drawable.kindofblue, R.string.kindofblue),
        newAlbumIndexing("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew, R.string.bitchesbrew),
        newAlbumIndexing("A Love Supreme", "John Coltrane", R.drawable.alovesupreme, R.string.alovesupreme)
    )

}