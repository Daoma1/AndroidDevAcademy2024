package com.demo.ada.deployment.di

import com.demo.ada.deployment.repository.PokemonRepository
import com.demo.ada.deployment.viewmodel.PokemonViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
}

val appModule = module {
    single { client }
    single { PokemonRepository(get()) }
    viewModel { PokemonViewModel(get()) }
}