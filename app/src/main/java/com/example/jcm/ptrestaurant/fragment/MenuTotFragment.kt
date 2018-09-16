package com.example.jcm.ptrestaurant.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast


import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.adapter.MenuRecyclerViewAdapter
import com.example.jcm.ptrestaurant.model.MenuList
import com.example.jcm.ptrestaurant.model.MenuRest
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList
import kotlinx.android.synthetic.main.content_menu.*
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuTotFragment : Fragment() {
    companion object {

        fun newInstance() = MenuTotFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    var menuList: List<MenuRest> ? = null
        set(value) {
            field = value
            if (value != null ){
                //Faltara por rellenar la llamada al adaptador
                menu_list.adapter = MenuRecyclerViewAdapter(value)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //Configuramos las animaciones para el ViewSwitcher
            view_switcher.setInAnimation(activity, android.R.anim.fade_in)
            view_switcher.setOutAnimation(activity, android.R.anim.fade_out)
            view.postDelayed({
            //Configuramos el RecyclerView. Primero decimos como se van a visualizar sus elementos
            menu_list.layoutManager = GridLayoutManager(activity,1)

            //Le decimos quien es el que anima al RecyclerView
            menu_list.itemAnimator = DefaultItemAnimator()

                menuList = MenuList.toArray().asList()

        }, 100.toLong())

    }

}
