package com.filbabic.androidacademy.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.filbabic.androidacademy.ui.main.components.SearchInput
import com.filbabic.androidacademy.ui.main.components.SearchResultList
import com.filbabic.androidacademy.ui.theme.AndroidAcademyTheme

class MainActivity : ComponentActivity() {

    private val resultState = mutableStateOf(emptyList<String>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreenContent() }
    }

    @Composable
    private fun MainScreenContent() {
        AndroidAcademyTheme {
            /**
             * User nesto upise. ->
             * - Moram spremati negdje input (string, state)
             * - Input field
             * - Samo tekstualni upis (moze li se upisivati broj)
             * - Pokazati user neki hint (optional)
             * - Sto ako je input prazan?
             * - Ima li neki input field limit?
             *
             * Klikne dugmic.
             * - Moram znati da je kliknut dugmic
             * - Funkcija koja nesto filtrira ovisno o inputu
             * - Updateaj state
             *
             * Pokazu se rezultati.
             * - Postoje neki moguci rezultati
             * - Filtriram ovisno o inputu
             * - Prikazem isfiltrirane rezultate
             * - Ako nema rezultata mogu nesto drugo pokazati
             */
            val searchInputState = mutableStateOf("Filip")
            val filteredResults = remember { resultState }

            Column(modifier = Modifier.fillMaxSize()) {
                // Search input
                SearchInput(
                    query = searchInputState.value,
                    onQueryChange = { searchInputState.value = it }
                )

                // Button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = { filterResults(searchInputState.value) },
                    content = { Text("Search") }
                )

                // Result list
                SearchResultList(
                    items = filteredResults.value
                )
            }
        }
    }

    private fun filterResults(value: String) {
        val filtered = possibleResults.filter { name ->
            name.contains(value, ignoreCase = true) // "Pacov" "pacov"
        }

        resultState.value = filtered
    }

    companion object {
        private val possibleResults = listOf(
            "Filip",
            "Leo",
            "Luka",
            "Ivan",
            "Brsadinski pacov"
        )
    }
}