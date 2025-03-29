package com.demo.ada.deployment.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.ada.deployment.repository.PokemonRepository
import com.demo.ada.deployment.viewmodel.PokemonViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val pokemons = viewModel.pokemons
    val errorMessage = viewModel.errorMessage

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        if (errorMessage != null) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.fetchPokemons() }) {
                Text("Retry")
            }
        } else {
            LazyColumn {
                items(pokemons.size) { pos ->
                    PokemonItem(pokemons[pos])
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonListScreen() {
    MaterialTheme {
        PokemonListScreen(viewModel = PokemonViewModel(PokemonRepository(HttpClient(CIO))))
    }
}
