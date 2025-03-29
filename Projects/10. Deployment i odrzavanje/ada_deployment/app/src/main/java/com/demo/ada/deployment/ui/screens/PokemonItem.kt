package com.demo.ada.deployment.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.ada.deployment.data.Pokemon



@Composable
fun PokemonItem(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = pokemon.name, style = MaterialTheme.typography.headlineSmall)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonItem() {
    MaterialTheme {
        PokemonItem(pokemon = Pokemon(name = "Pikatchu", "https://pokeapi.co"))
    }
}