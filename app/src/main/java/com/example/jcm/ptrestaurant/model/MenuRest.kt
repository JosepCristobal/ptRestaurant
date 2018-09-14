package com.example.jcm.ptrestaurant.model

import java.io.Serializable

data class MenuRest(val idMenu: String, val description: String, val icon: Int, val price: Float,
                    val detail: String, val allergen: List<Allergen>, var menuobs: String) : Serializable{

}