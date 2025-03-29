package com.demo.ada.deployment.repository

import com.demo.ada.deployment.data.Pokemon
import com.demo.ada.deployment.data.PokemonResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json

class PokemonRepository(private val client: HttpClient) {
    suspend fun fetchPokemons(): List<Pokemon> {
        return try {
            val response: HttpResponse = client.get("https://pokeapi.co/api/v2/pokemon?limit=20")
            val responseBody: String = response.body()
            Json.decodeFromString<PokemonResponse>(string = responseBody).results
        } catch (e: Exception) {
            throw e
        }
    }
}