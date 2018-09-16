package com.example.jcm.ptrestaurant.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.fragment.MenuFragment
import com.example.jcm.ptrestaurant.model.MenuRest
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList

import kotlinx.android.synthetic.main.activity_menu.*

class MenuTableActivity : AppCompatActivity() {

    companion object {
        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context, tableMenu: TableMenu): Intent {
            val intent = Intent(context, MenuTableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, tableMenu)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val initialTableMenu: TableMenu = intent.getSerializableExtra(EXTRA_TABLE) as TableMenu

        //Primero deberemos comprobar que no tengamos añadido ningun fragment a nuestra jerarquía
        //Al girar el dispositivo tendríamos problemas de redibujo y sobrecarga de fragments

        if (supportFragmentManager.findFragmentById(R.id.menu_list_fragment) == null) {
            val fragment: MenuFragment = MenuFragment.newInstance(initialTableMenu)

            supportFragmentManager.beginTransaction()
                    .add(R.id.menu_list_fragment, fragment)
                    .commit()
        }
    }
}
