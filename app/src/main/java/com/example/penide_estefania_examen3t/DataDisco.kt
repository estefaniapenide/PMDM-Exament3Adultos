package com.example.penide_estefania_examen3t

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class DataDisco(application: Application) : AndroidViewModel(application) {
    private val resources = application.resources

    public val listadoRock: MutableList<Disco> = ArrayList()
    public val listadoBlues:MutableList<Disco> = ArrayList()
    public val listadoJazz:MutableList<Disco> = ArrayList()

    public var listaDiscos: MutableLiveData<MutableList<Disco>> = MutableLiveData(ArrayList()) //Podía haber usado esto desde aqui!!!


    init {
        listaRock()
        listaBlues()
        listaJazz()
    }

    public fun listaRock() {
        listadoRock.add(
            Disco(1,
                "Abbey Road",
                "The Beatles",
                R.drawable.abbeyroad, resources.getString(R.string.abbeyroad)
            )
        )

        listadoRock.add(
            Disco(2,
                "Exile on Main Street",
                "The Rolling Stones",
                R.drawable.exileonmainst,
                resources.getString(R.string.exilesonmainstreet)
            )
        )
        listadoRock.add(
            Disco(3,
                "The Velvet Underground",
                "The Velvet Underground and Nico",
                R.drawable.velvetunderground,
                resources.getString(R.string.velvetunderground)
            )
        )
        listadoRock.add(
            Disco(4,
                "Are You Experienced",
                "Jimi Hendrix",
                R.drawable.areyouexperienced,
                resources.getString(R.string.areyouexperienced)
            )
        )
        listadoRock.add(
            Disco(5,
                "Back in Black",
                "AC/DC",
                R.drawable.backinblack,
                resources.getString(R.string.backinblack)
            )
        )
        listadoRock.add(
            Disco(6,
                "Appetite for Destruction",
                "Guns N’ Roses",
                R.drawable.appetitefordestruction,
                resources.getString(R.string.appetitefordestruction)
            )
        )
        listadoRock.add(
            Disco(7,
                "Led Zeppelin IV",
                "Led Zeppelin",
                R.drawable.ledzeppeliniv,
                resources.getString(R.string.ledzeppeliniv)
            )
        )

    }

    public fun listaBlues() {
        listadoBlues.add(
            Disco(8,
                "Lady Soul",
                "Aretha Franklin",
                R.drawable.ladysoul,
                resources.getString(R.string.ladysoul)
            )
        )
        listadoBlues.add(
            Disco(9,
                "I Never Loved a Man the Way I Love You",
                "Aretha Franklin",
                R.drawable.neverloved,
                resources.getString(R.string.ineverloveda)
            )
        )
        listadoBlues.add(
            Disco(10,
                "What's Going On",
                "Marvin Gaye",
                R.drawable.whatsgoingon,
                resources.getString(R.string.whatsgoingon)
            )
        )
    }

    public fun listaJazz() {
        listadoJazz.add(
            Disco(11,
                "Kind of Blue",
                "Miles Davis",
                R.drawable.kindofblue,
                resources.getString(R.string.kindofblue)
            )
        )
        listadoJazz.add(
            Disco(12,
                "Bitches Brew",
                "Miles Davis",
                R.drawable.bitchesbrew,
                resources.getString(R.string.bitchesbrew)
            )
        )
        listadoJazz.add(
            Disco(13,
                "A Love Supreme",
                "John Coltrane",
                R.drawable.alovesupreme,
                resources.getString(R.string.alovesupreme)
            )
        )

    }
}