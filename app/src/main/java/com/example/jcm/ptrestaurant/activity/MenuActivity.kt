package com.example.jcm.ptrestaurant.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.fragment.MenuFragment
import com.example.jcm.ptrestaurant.fragment.MenuTotFragment
import com.example.jcm.ptrestaurant.model.MenuList
import com.example.jcm.ptrestaurant.model.MenuRest
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList

import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //Primero deberemos comprobar que no tengamos añadido ningun fragment a nuestra jerarquía
        //Al girar el dispositivo tendríamos problemas de redibujo y sobrecarga de fragments

        if (supportFragmentManager.findFragmentById(R.id.menu_list_fragment) == null) {

            val fragment = MenuTotFragment.newInstance()

            supportFragmentManager.beginTransaction()
                    .add(R.id.menu_list_fragment, fragment)
                    .commit()
        }

    }
}
