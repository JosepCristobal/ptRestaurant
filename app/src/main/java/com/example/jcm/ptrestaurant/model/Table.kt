package com.example.jcm.ptrestaurant.model

import java.io.Serializable

data class Table(var idTable: String, var description: String): Serializable{
    override fun toString() = "${idTable}   ${description}"
}