package com.davidtakac.userprofile.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.davidtakac.userprofile.App
import com.davidtakac.userprofile.data.GetQuotesResult
import com.davidtakac.userprofile.data.InitializeUserResult
import com.davidtakac.userprofile.data.QuoteRepository
import com.davidtakac.userprofile.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val userRepository: UserRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<DashboardUiState>(value = DashboardUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun getDashboardState() {
        val currState = _uiState.value
        if (currState == DashboardUiState.Loading || currState is DashboardUiState.Success) return
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading

            val quotesResult = quoteRepository.getQuotes()
            if (quotesResult !is GetQuotesResult.Success) {
                _uiState.value = DashboardUiState.Error
                return@launch
            }

            val initUserResult = userRepository.initializeUser()
            if (initUserResult != InitializeUserResult.Success) {
                _uiState.value = DashboardUiState.Error
                return@launch
            }

            val initialUser = userRepository.user.value
            if (initialUser == null) {
                _uiState.value = DashboardUiState.Error
                return@launch
            }

            _uiState.value = DashboardUiState.Success(
                quotes = quotesResult.quotes,
                username = initialUser.name
            )

            observeUserNameChanges()
        }
    }

    private suspend fun observeUserNameChanges() {
        userRepository.user.collect { user ->
            val currState = _uiState.value
            if (currState !is DashboardUiState.Success || user == null) return@collect
            _uiState.value = currState.copy(username = user.name)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[APPLICATION_KEY]) as App
                DashboardViewModel(
                    userRepository = app.userRepository,
                    quoteRepository = app.quoteRepository
                )
            }
        }
    }
}
