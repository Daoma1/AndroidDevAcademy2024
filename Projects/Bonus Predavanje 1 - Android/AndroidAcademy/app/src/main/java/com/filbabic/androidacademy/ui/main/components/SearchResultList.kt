package com.filbabic.androidacademy.ui.main.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SearchResultList(items: List<String>) {
    for (item in items) {
        Text(item)
    }
}