package com.example.jcm.ptrestaurant.fragment


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.jcm.ptrestaurant.R
import com.example.jcm.ptrestaurant.model.Table
import com.example.jcm.ptrestaurant.model.TableMenu
import com.example.jcm.ptrestaurant.model.TableMenuList
import com.example.jcm.ptrestaurant.model.TablesList
import kotlinx.android.synthetic.main.fragment_tables.*
import kotlin.math.roundToLong


class TablesFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = TablesFragment()
    }
    //Creamos un atributo que va a ser el listener
    private var onTableSelectedListener: OnTableSelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tables, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val tablesL = TablesList
       // val adapter = ArrayAdapter<Table>(activity, android.R.layout.simple_list_item_1,
            //    tablesL.toArray())

//pruebas de calculo para total platos
        val tablesL = TableMenuList
        //val iterate = TableMenuList.
        val totalPlates= tablesL.calculPlates(0)
        val lista: MutableList<TableMenu> = ArrayList()
        val otraLista = tablesL.toArray()
        val iterate = otraLista.listIterator()
        while(iterate.hasNext()){
            val oldValue = iterate.next()
            val totalPlates = oldValue.menutable.size
            val totalChar = oldValue.description.length
            val textTables = "Platos: " + totalPlates.toString()

            var precio = 0f

            oldValue.menutable.forEach { precio += it.price }
            val totCheck = "Total de la mesa: ${ "%.2f".format(precio).toString()}"

            oldValue.description = "${oldValue.description.padEnd(150 - totalChar)}  $textTables  $totCheck"
            iterate.set(oldValue)
        }
//Fin de pruebas

        val adapter = ArrayAdapter<TableMenu>(activity, android.R.layout.simple_list_item_1,
              otraLista //tablesL.toArray()
        )
        tables_list.adapter = adapter
        //Queremos saber que fila se ha pulsado en la lista
        tables_list.setOnItemClickListener{_, _, index, _ ->
            //Avisamos al listener que una mesa ha sido seleccionada
            onTableSelectedListener?.onTableSelected(tablesL[index], index)
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as? Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }
    //Creamos método para las dos funciones anteriores
    private fun commonAttach(activity: Activity?) {
        if(activity is OnTableSelectedListener){
            onTableSelectedListener = activity
        } else {
            onTableSelectedListener = null
        }

    }

    override fun onDetach() {
        super.onDetach()
        onTableSelectedListener = null
    }
    //Creamos una interfaz que deberá implementar la actividad para poder saber que se ha pulsado una fila
    interface OnTableSelectedListener {
        fun onTableSelected(table: TableMenu, position: Int)
    }
}
