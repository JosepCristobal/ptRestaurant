package com.example.jcm.ptrestaurant.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.ViewGroup
import android.widget.*
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.model.Allergen
import com.example.jcm.ptrestaurant.model.AllergensList
import com.example.jcm.ptrestaurant.model.MenuList
import com.example.jcm.ptrestaurant.model.TableMenuList
import kotlinx.android.synthetic.main.activity_alergenos.*
import java.lang.reflect.Array

class Alergeno : AppCompatActivity() {

    companion object {

        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"
        val EXTRA_MENU_INDEX = "EXTRA_MENU_INDEX"

        fun intent(context: Context, tableIndex: Int, menuIndex: Int): Intent {
            val intent = Intent(context, Alergeno::class.java)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)
            intent.putExtra(EXTRA_MENU_INDEX, menuIndex)

            return intent
        }
    }

    val COLUMNS = 2
    val tableLayout by lazy { TableLayout(this) }
    val alerogens = AllergensList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alergenos)

        val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tableLayout.apply {
            layoutParams = lp
            isShrinkAllColumns = true
        }

        createTable()
    }


    fun createTable() {
        val table2 = TableMenuList[intent.getIntExtra(EXTRA_TABLE_INDEX, 0)]
        //val menuIndex2 = intent.getIntExtra(EXTRA_MENU_INDEX, -1)
        val extraTable = intent.getIntExtra(EXTRA_TABLE_INDEX,0)
        val extraMenu = intent.getIntExtra(EXTRA_MENU_INDEX, 0)

        val menuP2 = table2.menutable[extraMenu]
        val menuP3 = MenuList.toArray()[extraMenu]
        lateinit var otraLista:MutableList<Allergen>

        if (extraTable == 0 && extraMenu == 0) {
            otraLista = alerogens.toArray()
        }else if(extraTable == 0 ){
            otraLista = menuP3.allergen.toMutableList()
        } else {
            otraLista = menuP2.allergen.toMutableList()
        }
        var rowsReal = (otraLista.size/2).toInt() + (otraLista.size % 2)

        val iterate = otraLista.listIterator()
        val rows = (otraLista.size/2).toInt()
        val cols = 2
        var contador = 0
        val totalReg = otraLista.size

        for (i in 0 until rowsReal) {

            val row = TableRow(this)
            row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

            for (j in 0 until cols) {
            if(contador >= totalReg) return
                contador += 1
                val button = Button(this)
                val image = ImageView(this)
                val textView = TextView(this)

                val iconAler = otraLista[contador -1].alleIcon
                val totalChardecAler = otraLista[contador -1].alleDescription
                image.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT)
                    image.setImageResource(iconAler)
                }

                textView.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT)
                    text = totalChardecAler
                }

                row.addView(image)
                row.addView(textView)
            }
            tableLayout.addView(row)
        }
        linearLayout.addView(tableLayout)
    }


}
