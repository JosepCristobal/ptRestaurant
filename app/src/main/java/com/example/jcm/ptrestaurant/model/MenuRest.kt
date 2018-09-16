package com.example.jcm.ptrestaurant.model

import java.io.Serializable

data class MenuRest(var idMenu: String, var description: String, var icon: Int, var price: Float,
                    var detail: String, var allergen: List<Allergen>, var menuobs: String) : Serializable{

}