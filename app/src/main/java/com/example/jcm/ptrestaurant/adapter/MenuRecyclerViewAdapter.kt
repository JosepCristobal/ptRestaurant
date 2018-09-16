package com.example.jcm.ptrestaurant.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.jcm.ptrestaurant.model.MenuRest
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.jcm.ptrestaurant.R

class MenuRecyclerViewAdapter (private val menuList: List<MenuRest>): RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuViewHolder>(){

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.content_menu, parent, false)
        //Le decimos a este view que cuando pulsen avise a nuestro onClicklistener
        view.setOnClickListener(onClickListener)

        return MenuViewHolder(view)
    }

    override fun getItemCount() = menuList.size


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindMenu(menuList[position])
    }

    //Empezamos con el view holder
    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val menuImage = itemView.findViewById<ImageView?>(R.id.menu_image)
        val plate = itemView.findViewById<TextView?>(R.id.plate)
        val num_plate = itemView.findViewById<TextView?>(R.id.num_plate)
        val price =  itemView.findViewById<TextView?>(R.id.price)
        val menu_description = itemView.findViewById<TextView?>(R.id.menu_description)
        val other = itemView.findViewById<TextView?>(R.id.other)
        val buttonAler = itemView.findViewById<Button>(R.id.alergen_button)

        fun bindMenu(menuList: MenuRest){
            //Atualizamos la vista con el modelo
            menuImage?.setImageResource(menuList.icon)
            plate?.text = menuList.description
            num_plate?.text ="Plato núm:  ${menuList.idMenu.toString()}"
            price?.text = "Precio:  ${menuList.price.toString()}€"
            menu_description?.text= "Descripción: ${menuList.detail.toString()}"
            other?.text = "Consideraciones: ${menuList.menuobs}"
            buttonAler.text = ""
        }

    }

}