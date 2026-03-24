package com.example.country.data
import com.example.country.model.Country
import com.example.country.R

class CountrySource {
    fun loadCountry(): List<Country> {
        return listOf<Country>(
            Country("RDC", "Kinshasa", "+243", R.drawable.rdc),
            Country("France", "Paris", "+33", R.drawable.france),
            Country("Italie", "Rome", "+39", R.drawable.italie),
            Country("Chine", "Pékin", "+86", R.drawable.chine),
            Country("Espagne", "Madrid", "+34", R.drawable.espagne),
            Country("Portugal", "Lisbonne", "+351", R.drawable.portugal),
            Country("Pologne", "Varsovie", "+48", R.drawable.pologne),
            Country("Japon", "Tokyo", "+81", R.drawable.japon),
            Country("Maroc", "Rabat", "+212", R.drawable.maroc),
            Country("USA", "Washington D.C.", "+1", R.drawable.usa)
        )
    }
}