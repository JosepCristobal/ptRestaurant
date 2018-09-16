package com.example.jcm.ptrestaurant.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Creamos el menu para hacer las llamadas a otras opciones
        menuInflater.inflate(R.menu.activity_tables, menu)
        //return super.onPrepareOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.carta_menu ->{
                //Lanzaremos la llamada al menú carta
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.alergenos -> {
                //Lanzaremos la llamada al menú carta
                val intent = Intent(this, Alergeno::class.java)
                startActivity(intent)
                return true
            }
            R.id.insert -> {
                //Lanzamos la llamada a la pantalla de inserción de platos
                val intent = Intent(this, Pruebas_insert::class.java)
                startActivity(intent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

    }
}
