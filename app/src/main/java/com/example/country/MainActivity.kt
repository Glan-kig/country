package com.example.country

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.country.ui.theme.CountryTheme
import com.example.country.model.Country
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.country.data.CountrySource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryTheme {
                CountryApp()
            }
        }
    }
}

@Composable
fun CountryApp(){
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        CountryList(
            CountrySource().loadCountry()
        )
    }
}

@Composable
fun CountryItem(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image du drapeau à gauche
            Image(
                painter = painterResource(id = country.drapeauRes),
                contentDescription = "Drapeau de ${country.nom}",
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 16.dp)
            )

            // Texte à droite (Nom et Capitale)
            Column {
                Text(text = country.nom, style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Capitale : ${country.capitale}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(text = "Code : ${country.code}", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Composable
fun CountryList(countries: List<Country>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(countries) { country ->
            CountryItem(country = country)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val fakeCountries = listOf(
        Country("RDC", "Kinshasa", "CD", android.R.drawable.ic_menu_myplaces),
        Country("France", "Paris", "FR", android.R.drawable.ic_menu_myplaces),
        Country("espagne", "Madrid", "ES", android.R.drawable.ic_menu_compass)
    )
    CountryTheme {
        CountryList(countries = fakeCountries)
    }
}