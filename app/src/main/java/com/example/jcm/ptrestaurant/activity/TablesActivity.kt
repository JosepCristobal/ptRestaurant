package com.example.jcm.ptrestaurant.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.fragment.TablesFragment
import com.example.jcm.ptrestaurant.model.TableMenu

class TablesActivity : AppCompatActivity(), TablesFragment.OnTableSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)


        //Primero deberemos comprobar que no tengamos añadido ningun fragment a nuestra jerarquía
        //Al girar el dispositivo tendríamos problemas de redibujo y sobrecarga de fragments

        if(supportFragmentManager.findFragmentById(R.id.table_list_fragment) == null) {
            // Añadimos el fragment de forma dinamica

            val fragment: TablesFragment = TablesFragment.newInstance()

            supportFragmentManager.beginTransaction()
                    .add(R.id.table_list_fragment, fragment)
                    .commit()
        }

    }

    override fun onTableSelected(table: TableMenu, position: Int) {
        val intent = MenuTableActivity.intent(this, table)
        startActivity(intent)
    }
}
