package com.davidtakac.userprofile

import android.app.Application
import com.davidtakac.userprofile.data.QuoteRemoteDataSource
import com.davidtakac.userprofile.data.QuoteRepository
import com.davidtakac.userprofile.data.UserRemoteDataSource
import com.davidtakac.userprofile.data.UserRepository

class App : Application() {
    private val quoteRemoteDataSource by lazy { QuoteRemoteDataSource() }
    private val userRemoteDataSource by lazy { UserRemoteDataSource() }

    val userRepository by lazy { UserRepository(userRemoteDataSource) }
    val quoteRepository by lazy { QuoteRepository(quoteRemoteDataSource) }
}