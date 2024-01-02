package com.focalors.hireai.ui.screen.register

import com.focalors.hireai.data.remote.response.User

data class RegisterState(
    val userData: User? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)