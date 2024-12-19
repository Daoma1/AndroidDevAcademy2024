package com.davidtakac.userprofile.data

import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.Month

class UserRemoteDataSource {
    suspend fun getUser(): User {
        delay(1000)
        return User(
            name = "David",
            birthday = LocalDate.of(1997, Month.JULY, 22),
            country = "Croatia"
        )
    }

    suspend fun setUsername(value: String) {
        delay(500)
    }

    suspend fun setBirthday(value: LocalDate) {
        delay(700)
    }

    suspend fun setCountry(value: String) {
        delay(100)
    }
}