package com.example.jcm.ptrestaurant.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        button.setOnClickListener{ addFiles(3,"Cambiamos las observaciones por las nuevas para la prueba de inserción 5", 7)}
    }


    fun addFiles(numPlate: Int, coment: String, numTable:Int){

        var regMenu:MenuRest = MenuList.toArray()[numPlate]
        regMenu.menuobs = coment

        val menuMesa = TableMenuList.toArray()[numTable].menutable.toMutableList()
        val totRegistros = TableMenuList.toArray()[numTable].menutable.toMutableList().size

        menuMesa.add(totRegistros, regMenu)

        TableMenuList[numTable].menutable = menuMesa

        val intent = Intent(this, TablesActivity::class.java)
        startActivity(intent)

    }
}
