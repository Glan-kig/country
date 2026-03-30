package com.example.country.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
data class Country(
    @StringRes val nom: Int,
    @StringRes val capitale: Int,
    @StringRes val code: Int,
    @DrawableRes val drapeauRes: Int // On stocke l'ID de la ressource (ex: R.drawable.france)
)