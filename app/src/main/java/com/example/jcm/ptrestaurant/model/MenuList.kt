package com.example.jcm.ptrestaurant.model

import com.example.jcm.ptrestaurant.R

object MenuList {
    private val menuList: MutableList<MenuRest> = mutableListOf(
            MenuRest("01","Esparragos",R.drawable.esparrago_langostino_r,10.05f,"Esparragos rellenos de langostinos y con salsa de aceite ligera",
                    listOf(
                            Allergen("04","Crustaceos", R.drawable.a_crustaceos ),
                            Allergen("06", "Gluten", R.drawable.a_gluten)),""
            ),

            MenuRest("02","Ensalada top chef",R.drawable.ensalada_mixta,9.05f,"Ensalada con brotes de soja con tofu y miel",
                    listOf(
                            Allergen("13", "Soja", R.drawable.a_soja),
                            Allergen("06", "Gluten", R.drawable.a_gluten)),""
            ),
            MenuRest("03","Sopa de pescado",R.drawable.sopa_pescado,11.05f,"Sopa de pescado con marisco del Cantabrico prodente de una pesca sostenible",
                    listOf(
                            Allergen("12", "Pescado", R.drawable.a_pescado),
                            Allergen("10", "Moluscos", R.drawable.a_moluscos),
                            Allergen("04","Crustaceos", R.drawable.a_crustaceos ),
                            Allergen("06", "Gluten", R.drawable.a_gluten)
                    ),""
            ),
            MenuRest("04","Lasaña",R.drawable.lasana_setas,12.05f,"Lasaña rellena de setas y gambas",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("04","Crustaceos", R.drawable.a_crustaceos ),
                            Allergen("06", "Gluten", R.drawable.a_gluten),
                            Allergen("10", "Moluscos", R.drawable.a_moluscos)

                    ),""
            ),
            MenuRest("05","Entrecotte brasa",R.drawable.entrecote_cabra,18.30f,"Entrecotte a la plancha con queso de cabra, pimimientos y patatas fritas",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("06", "Gluten", R.drawable.a_gluten)

                    ),""
            ),

            MenuRest("06","Carrilleras de ibérico",R.drawable.carrillera_glaseada,16.15f,"Carrilleras de ibérico glaseadas, puré de patata y vainilla",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("08", "Huevo", R.drawable.a_huevo)

                    ),""
            ),

            MenuRest("07","Salmón a la plancha",R.drawable.salmon_plancha,18.35f,"Salmón a la plancha con salsa tártara y verduras a la parrilla",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("12", "Pescado", R.drawable.a_pescado)


                    ),""
            ),

            MenuRest("08","Arroz a banda",R.drawable.arroz_banda,17.25f,"Arroz a banda con atún, sepia y gamba roja pelada",
                    listOf(
                            Allergen("12", "Pescado", R.drawable.a_pescado),
                            Allergen("10", "Moluscos", R.drawable.a_moluscos),
                            Allergen("04","Crustaceos", R.drawable.a_crustaceos ),
                            Allergen("06", "Gluten", R.drawable.a_gluten)

                    ),""
            ),
            MenuRest("09","Mousse",R.drawable.mouse_requeson,10.00f,"Mousse de requesón y melocotón de calanda al tomillo",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("08", "Huevo", R.drawable.a_huevo)

                    ),""
            ),

            MenuRest("10","Copa de tiramisú",R.drawable.mouse_requeson,10.00f,"Copa de tiramisú con gelé de café y bizcocho de soletilla",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("08", "Huevo", R.drawable.a_huevo),
                            Allergen("06", "Gluten", R.drawable.a_gluten),
                            Allergen("14", "Sulfitos", R.drawable.a_sulfitos)


                    ),""
            ),
            MenuRest("11","Sorbete de mandarina",R.drawable.sorbete_mandarina,10.00f,"Sorbete de mandarina con un toque especial de la casa",
                    listOf(
                            Allergen("09", "Lacteos", R.drawable.a_lacteos),
                            Allergen("14", "Sulfitos", R.drawable.a_sulfitos)

                    ),""
            )

            )
        val count
                get() = MenuList.menuList.size

        fun toArray() = MenuList.menuList.toTypedArray()

        fun oneMenu() = MenuList.menuList.toMutableList()
}