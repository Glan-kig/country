package com.example.country.model

data class Country(
    val nom: String,
    val capitale: String,
    val code: String,
    val drapeauRes: Int // On stocke l'ID de la ressource (ex: R.drawable.france)
)