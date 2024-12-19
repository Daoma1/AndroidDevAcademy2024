package com.davidtakac.userprofile.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.davidtakac.userprofile.App
import com.davidtakac.userprofile.data.InitializeUserResult
import com.davidtakac.userprofile.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<SettingsUiState>(value = SettingsUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun getSettingsState() {
        val currState = _uiState.value
        if (currState == SettingsUiState.Loading || currState is SettingsUiState.Success) return
        viewModelScope.launch {
            _uiState.value = SettingsUiState.Loading

            val initUserResult = userRepository.initializeUser()
            if (initUserResult != InitializeUserResult.Success) {
                _uiState.value = SettingsUiState.Error
                return@launch
            }

            val initialUser = userRepository.user.value
            if (initialUser == null) {
                _uiState.value = SettingsUiState.Error
                return@launch
            }

            _uiState.value = SettingsUiState.Success(
                username = initialUser.name,
                onlyPositiveQuotes = true,
                shuffle = false
            )

            observeUserNameChanges()
        }
    }

    private suspend fun observeUserNameChanges() {
        userRepository.user.collect { user ->
            val currState = _uiState.value
            if (currState !is SettingsUiState.Success || user == null) return@collect
            _uiState.value = currState.copy(username = user.name)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App
                SettingsViewModel(
                    userRepository = app.userRepository,
                )
            }
        }
    }
}