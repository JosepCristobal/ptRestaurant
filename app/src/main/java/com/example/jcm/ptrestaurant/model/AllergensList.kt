package com.example.jcm.ptrestaurant.model

import com.example.jcm.ptrestaurant.R

object AllergensList{

    private val allergenList: List<Allergen> = listOf(
           Allergen("01","Altramuces", R.drawable.a_altramuces),
            Allergen("02", "Apio", R.drawable.a_apio),
            Allergen("03", "Cacahuete", R.drawable.a_cacahuete),
            Allergen("04","Crustaceos", R.drawable.a_crustaceos ),
            Allergen("05", "Frutos de cáscara", R.drawable.a_frutocascara),
            Allergen("06", "Gluten", R.drawable.a_gluten),
            Allergen("07","Grano de sésamo", R.drawable.a_granosesamo),
            Allergen("08", "Huevo", R.drawable.a_huevo),
            Allergen("09", "Lacteos", R.drawable.a_lacteos),
            Allergen("10", "Moluscos", R.drawable.a_moluscos),
            Allergen("11", "Mostaza", R.drawable.a_mostaza),
            Allergen("12", "Pescado", R.drawable.a_pescado),
            Allergen("13", "Soja", R.drawable.a_soja),
            Allergen("14", "Sulfitos", R.drawable.a_sulfitos)
    )


    fun toArray() = allergenList.toMutableList()
}