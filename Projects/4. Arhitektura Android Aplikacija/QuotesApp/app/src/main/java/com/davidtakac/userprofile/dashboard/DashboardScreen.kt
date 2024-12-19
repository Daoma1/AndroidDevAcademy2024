package com.davidtakac.userprofile.dashboard

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    uiState: DashboardUiState,
    onSettingsClicked: () -> Unit,
    onTryAgainClicked: () -> Unit,
) {
    when (uiState) {
        DashboardUiState.Error -> ErrorScreen(onTryAgainClicked)
        DashboardUiState.Idle, DashboardUiState.Loading -> LoadingScreen()
        is DashboardUiState.Success -> SuccessScreen(
            username = uiState.username,
            quotes = uiState.quotes,
            onSettingsClicked = onSettingsClicked
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SuccessScreen(
    username: String,
    quotes: List<String>,
    onSettingsClicked: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = { Text(text = "Hello, $username") },
                actions = {
                    IconButton(onClick = onSettingsClicked) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(contentPadding)) {
            items(quotes) {
                Text(
                    text = it,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                        vertical = 12.dp
                    )
                )
            }
        }
    }
}