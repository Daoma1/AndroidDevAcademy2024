package com.davidtakac.userprofile.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserRepository(private val userRemoteDataSource: UserRemoteDataSource) {
    private val _user = MutableStateFlow<User?>(value = null)
    val user = _user.asStateFlow()

    suspend fun initializeUser(): InitializeUserResult {
        if (_user.value != null) return InitializeUserResult.Success
        return try {
            _user.value = userRemoteDataSource.getUser()
            InitializeUserResult.Success
        } catch (_: Exception) {
            InitializeUserResult.Failure
        }
    }

    suspend fun changeUserName(value: String): ChangeUserNameResult {
        return try {
            userRemoteDataSource.setUsername(value)
            _user.value = _user.value?.copy(name = value)
            ChangeUserNameResult.Success
        } catch (_: Exception) {
            ChangeUserNameResult.Failure
        }
    }
}

enum class InitializeUserResult {
    Success, Failure
}

enum class ChangeUserNameResult {
    Success, Failure
}