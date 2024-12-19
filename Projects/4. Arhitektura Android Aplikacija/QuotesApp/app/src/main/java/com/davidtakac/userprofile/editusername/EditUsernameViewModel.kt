package com.davidtakac.userprofile.editusername

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.davidtakac.userprofile.App
import com.davidtakac.userprofile.data.ChangeUserNameResult
import com.davidtakac.userprofile.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditUsernameViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<EditUsernameUiState>(EditUsernameUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun changeUserName(value: String) {
        val currState = _uiState.value
        if (currState == EditUsernameUiState.InProgress || currState == EditUsernameUiState.Success) return
        viewModelScope.launch {
            _uiState.value = EditUsernameUiState.InProgress
            val changeResult = userRepository.changeUserName(value)
            _uiState.value =
                if (changeResult == ChangeUserNameResult.Success) EditUsernameUiState.Success
                else EditUsernameUiState.Failure
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App
                EditUsernameViewModel(
                    userRepository = app.userRepository,
                )
            }
        }
    }
}