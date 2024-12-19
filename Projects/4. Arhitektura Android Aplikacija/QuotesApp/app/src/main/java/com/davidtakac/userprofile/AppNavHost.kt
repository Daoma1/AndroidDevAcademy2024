package com.davidtakac.userprofile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.davidtakac.userprofile.dashboard.DashboardScreen
import com.davidtakac.userprofile.dashboard.DashboardViewModel
import com.davidtakac.userprofile.editusername.EditUsernameScreen
import com.davidtakac.userprofile.editusername.EditUsernameUiState
import com.davidtakac.userprofile.editusername.EditUsernameViewModel
import com.davidtakac.userprofile.settings.SettingsScreen
import com.davidtakac.userprofile.settings.SettingsViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Dashboard

@Serializable
data object Settings

@Serializable
data class EditUsername(val initialUsername: String)

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Dashboard) {
        composable<Dashboard> {
            val viewModel = viewModel<DashboardViewModel>(factory = DashboardViewModel.Factory)
            LaunchedEffect(Unit) { viewModel.getDashboardState() }
            DashboardScreen(
                uiState = viewModel.uiState.collectAsState().value,
                onSettingsClicked = { navController.navigate(Settings) },
                onTryAgainClicked = { viewModel.getDashboardState() }
            )
        }

        composable<Settings> {
            val viewModel = viewModel<SettingsViewModel>(factory = SettingsViewModel.Factory)
            LaunchedEffect(Unit) { viewModel.getSettingsState() }
            SettingsScreen(
                uiState = viewModel.uiState.collectAsState().value,
                onEditUsernameClicked = { currentUsername -> navController.navigate(EditUsername(initialUsername = currentUsername)) },
                onTryAgainClicked = { viewModel.getSettingsState() }
            )
        }

        composable<EditUsername> {
            val initialUsername = it.toRoute<EditUsername>().initialUsername
            val viewModel = viewModel<EditUsernameViewModel>(factory = EditUsernameViewModel.Factory)
            val state = viewModel.uiState.collectAsState().value
            LaunchedEffect(state) {
                if (state == EditUsernameUiState.Success) {
                    navController.popBackStack()
                }
            }
            EditUsernameScreen(
                initialUserName = initialUsername,
                editStatus = state,
                onSaveClicked = { newUserName -> viewModel.changeUserName(newUserName) },
            )
        }
    }
}