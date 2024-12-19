package com.davidtakac.userprofile.settings

sealed interface SettingsUiState {
    data object Idle : SettingsUiState

    data object Loading : SettingsUiState

    data object Error : SettingsUiState

    data class Success(
        val username: String,
        val onlyPositiveQuotes: Boolean,
        val shuffle: Boolean,
    ) : SettingsUiState
}