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
        button.setOnClickListener{ addFiles()}
    }


    fun addFiles(){
        //Esta es la lista de las mesas con su contenido de menus
        val tableMenuList : TableMenuList
        // Esta es la base de los menús
        val menuRest:MenuRest

        //Este es la lista de menus
        val menuList: MenuList

        //Esta es la base de cada una de las mesas
        val tableMenu:TableMenu

        val regMenu:MenuRest = MenuList.toArray()[2]
        regMenu.menuobs = "Cambiamos las observaciones por las nuevas"
        //regMenu.copy("Mesa_11","Pruebas de insercion",R.drawable.sorbete_mandarina,10.00f,"Sorbete de mandarina con un toque especial de la casa"," ","Mis Observaciones")
        MenuList.oneMenu().add(2, regMenu)

        val regMenuInTable:TableMenu = TableMenuList.toArray()[1]
        regMenuInTable
        val regListMenuInTable:TableMenuList = TableMenuList


        TableMenuList.toArray().add(1,regMenu)


        val e = 2
        val intent = Intent(this, TablesActivity::class.java)
        startActivity(intent)

    }
}
