package com.example.jcm.ptrestaurant.activity

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.widget.Toast
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.model.MenuList
import com.example.jcm.ptrestaurant.model.MenuRest
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList
import kotlinx.android.synthetic.main.activity_pruebas_insert.*

class Pruebas_insert : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pruebas_insert)
        button.setOnClickListener{ addFiles()}
        text_mesa.requestFocus()
    }

    fun addFiles(){
        val numPlate: Int = text_plato.text.toString().toInt()
        val coment: String = text_comentario.text.toString()
        val numTable:Int = text_mesa.text.toString().toInt()-1

        if ((numTable>10 || numPlate>11 || numTable<0 || numPlate<0) && (numTable == null || numPlate== null)) {
            Toast.makeText(this,
                    "El número de mesa entre 1 y 10 El número de plato entre 1 y 12",
                    Toast.LENGTH_LONG).show()
            text_plato.text.clear()
            text_mesa.text.clear()
            return
        }

        var regMenu:MenuRest = MenuList.toArray()[numPlate-1]
        regMenu.menuobs = coment

        val menuMesa = TableMenuList.toArray()[numTable].menutable.toMutableList()
        val totRegistros = TableMenuList.toArray()[numTable].menutable.toMutableList().size

        menuMesa.add(totRegistros, regMenu)

        TableMenuList[numTable].menutable = menuMesa
        text_plato.text.clear()
        text_mesa.text.clear()
        text_comentario.text.clear()

        this.finish() //onBackPressed()

    }
}
