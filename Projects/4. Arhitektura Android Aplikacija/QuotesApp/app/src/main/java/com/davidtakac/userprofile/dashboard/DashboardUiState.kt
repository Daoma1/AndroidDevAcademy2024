package com.davidtakac.userprofile.dashboard

sealed interface DashboardUiState {
    data object Idle : DashboardUiState

    data object Loading : DashboardUiState
    
    data object Error : DashboardUiState
    
    data class Success(
        val username: String,
        val quotes: List<String>
    ) : DashboardUiState
}
