package com.filbabic.androidacademy.ui.main.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable

@Composable
fun SearchInput(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
    )
}