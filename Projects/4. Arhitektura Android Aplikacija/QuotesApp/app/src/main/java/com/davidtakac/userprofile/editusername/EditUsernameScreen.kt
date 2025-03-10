package com.davidtakac.userprofile.editusername

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUsernameScreen(
    initialUserName: String,
    editStatus: EditUsernameUiState,
    onSaveClicked: (String) -> Unit,
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Edit username") }) }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var userName by remember { mutableStateOf(initialUserName) }
            TextField(
                value = userName,
                placeholder = { Text("Username") },
                onValueChange = { newValue -> userName = newValue },
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { onSaveClicked(userName) },
                enabled = editStatus != EditUsernameUiState.InProgress
            ) {
                Text(text = "Save")
            }
        }
    }
}