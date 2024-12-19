package com.davidtakac.userprofile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    uiState: SettingsUiState,
    onEditUsernameClicked: (String) -> Unit,
    onTryAgainClicked: () -> Unit
) {
    when (uiState) {
        SettingsUiState.Error -> ErrorScreen(onTryAgainClicked)
        SettingsUiState.Loading, SettingsUiState.Idle -> LoadingScreen()
        is SettingsUiState.Success -> SuccessScreen(
            username = uiState.username,
            onlyPositiveQuotes = uiState.onlyPositiveQuotes,
            shuffle = uiState.shuffle,
            onEditUsernameClicked = onEditUsernameClicked
        )
    }
}

@Composable
private fun ErrorScreen(onTryAgainClicked: () -> Unit) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Error", modifier = Modifier.padding(it))
            Button(onClick = onTryAgainClicked) {
                Text("Try again")
            }
        }
    }
}

@Composable
private fun LoadingScreen() {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(modifier = Modifier.padding(it))
        }
    }
}

@Composable
private fun SuccessScreen(
    username: String,
    onlyPositiveQuotes: Boolean,
    shuffle: Boolean,
    onEditUsernameClicked: (String) -> Unit
) {
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = username,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { onEditUsernameClicked(username) }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                item {
                    SettingsSwitch(
                        label = "Only positive quotes",
                        checked = onlyPositiveQuotes,
                        onCheckedChange = { TODO() }
                    )
                }
                item {
                    SettingsSwitch(
                        label = "Shuffle every time",
                        checked = shuffle,
                        onCheckedChange = { TODO() }
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsSwitch(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onCheckedChange(!checked) }
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        Switch(checked = checked, onCheckedChange = null)
    }
}