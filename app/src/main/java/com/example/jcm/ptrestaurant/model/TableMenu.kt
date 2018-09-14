package com.example.jcm.ptrestaurant.model

import java.io.Serializable

data class TableMenu(var idTable: String, var description: String, var menutable: List<MenuRest>) : Serializable {
    override fun toString() = "${idTable}   ${description}"

}