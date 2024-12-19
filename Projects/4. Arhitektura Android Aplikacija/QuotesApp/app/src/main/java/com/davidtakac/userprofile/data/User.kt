package com.davidtakac.userprofile.data

import java.time.LocalDate

data class User(
    val name: String,
    val country: String,
    val birthday: LocalDate
)