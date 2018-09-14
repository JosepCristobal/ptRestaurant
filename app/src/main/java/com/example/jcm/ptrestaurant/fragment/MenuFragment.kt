package com.example.jcm.ptrestaurant.fragment


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.GridLayoutManager


import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.activity.DetailMenuActivity
import com.example.jcm.ptrestaurant.adapter.MenuRecyclerViewAdapter
import com.example.jcm.ptrestaurant.model.MenuList
import com.example.jcm.ptrestaurant.model.MenuRest
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList
import kotlinx.android.synthetic.main.content_menu.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlin.math.roundToLong


class MenuFragment : Fragment() {
    companion object {

        val ARG_TABLE = "ARG_TABLE"

        fun newInstance(tableMenu: TableMenu):MenuFragment{
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, tableMenu)
            val fragment = MenuFragment()
            fragment.arguments = arguments

            return fragment
        }
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

                val adapter = MenuRecyclerViewAdapter(value)

                menu_list.adapter = adapter
                //Si alguien pulsa una fila, nos queremos enterar
                setRecyclerViewClickListener()
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

                val menuTable: TableMenu = arguments?.getSerializable(ARG_TABLE) as TableMenu


                menuList = menuTable.menutable.toMutableList()

               var element = menuTable.menutable.toTypedArray()

                //Calculo del precio
                var precio = 0f
                element.forEach { precio += it.price }
                val totCheck = "Total de la mesa: ${precio.toString()}"

                Snackbar.make(view!!, totCheck, Snackbar.LENGTH_LONG)
                        .show()

        }, 100.toLong())
    }

    fun setRecyclerViewClickListener() {
        // Si alguien pulsa un elemento del RecyclerView, nos queremos enterar aquí
        val adapter = menu_list?.adapter as? MenuRecyclerViewAdapter
        adapter?.onClickListener = View.OnClickListener {
            // Alguien ha pulsado un elemento del RecyclerView
            val MenuIndex = menu_list.getChildAdapterPosition(it)
            val tableI = arguments?.getSerializable(ARG_TABLE) as TableMenu
            val tableIndex = TableMenuList.getIndex(tableI)

            // Opciones especiales para navegar con vistas comunes
            val animationOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity!!,
                    it,
                    "transition_to_detail"
            )

            startActivity(DetailMenuActivity.intent(activity!!, tableIndex, MenuIndex), animationOptions.toBundle())
        }
    }
}
