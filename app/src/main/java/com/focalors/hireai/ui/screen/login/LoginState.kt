package com.focalors.hireai.ui.screen.login

import com.focalors.hireai.data.remote.response.User

data class LoginState(
    val userData: User? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)