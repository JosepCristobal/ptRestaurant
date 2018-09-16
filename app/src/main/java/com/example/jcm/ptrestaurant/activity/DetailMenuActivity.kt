package com.example.jcm.ptrestaurant.activity

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.ViewGroup
import android.widget.*
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.model.Allergen
import com.example.jcm.ptrestaurant.model.AllergensList
import com.example.jcm.ptrestaurant.model.TableMenuList
import kotlinx.android.synthetic.main.activity_alergenos.*
import kotlinx.android.synthetic.main.content_menu.*

class DetailMenuActivity : AppCompatActivity() {

    companion object {

        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"
        val EXTRA_MENU_INDEX = "EXTRA_MENU_INDEX"

        fun intent(context: Context, tableIndex: Int, menuIndex: Int): Intent {
            val intent = Intent(context, DetailMenuActivity::class.java)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)
            intent.putExtra(EXTRA_MENU_INDEX, menuIndex)

            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        // Sacamos los datos con los que configurar la interfaz
        val table = TableMenuList[intent.getIntExtra(EXTRA_TABLE_INDEX, -1)]
        val menuIndex = intent.getIntExtra(EXTRA_MENU_INDEX, -1)
        val menuP = table.menutable[menuIndex]

        // Actualizamos la interfaz
        plate?.text = menuP.description
        menu_image?.setImageResource(menuP.icon)
        num_plate?.text ="Plato núm:  ${menuP.idMenu.toString()}"
        price?.text = "Precio:  ${menuP.price.toString()}€"
        menu_description?.text= "Descripción: ${menuP.detail.toString()}"
        other?.text = "Consideraciones: ${menuP.menuobs}"


        alergen_button.setOnClickListener {

            Toast.makeText(this, "Lista de alérgenos", Toast.LENGTH_LONG).show()
            createTable()
        }


    }


    fun createTable() {
       val intent = Alergeno.intent(
               this,
               intent.getIntExtra(EXTRA_TABLE_INDEX, -1),
               intent.getIntExtra(EXTRA_MENU_INDEX, -1))

        startActivity(intent)

    }



}
