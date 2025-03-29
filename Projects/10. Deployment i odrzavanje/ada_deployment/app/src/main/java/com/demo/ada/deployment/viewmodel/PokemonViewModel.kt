package com.demo.ada.deployment.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.ada.deployment.data.Pokemon
import com.demo.ada.deployment.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository): ViewModel() {

    private var _pokemons = mutableStateOf<List<Pokemon>>(emptyList())
    val pokemons = _pokemons.value

    private var _errorMessage = mutableStateOf<String?>(null)
    val errorMessage = _errorMessage.value

    init {
        fetchPokemons()
    }

    fun fetchPokemons() {
        viewModelScope.launch {
            try {
                _pokemons.value = repository.fetchPokemons()
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data. Check your internet connection."
            }
        }
    }
}