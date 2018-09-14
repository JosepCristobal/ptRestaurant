package com.example.jcm.ptrestaurant.model


object TablesList {
    private val tablesList: List<Table> = listOf(
            Table("Mesa01","Berasategui"),
            Table("Mesa02", "Adria"),
            Table("Mesa03", "Arzak"),
            Table("Mesa04", "Ruscalleda"),
            Table("Mesa05", "Dacosta"),
            Table("Mesa06", "Aduriz"),
            Table("Mesa07", "Muñoz"),
            Table("Mesa08", "Roca"),
            Table("Mesa09", "Cruz"),
            Table("Mesa10", "Arguiñano")
    )


    val count
        get() = tablesList.size

    fun toArray() = tablesList.toTypedArray()


}