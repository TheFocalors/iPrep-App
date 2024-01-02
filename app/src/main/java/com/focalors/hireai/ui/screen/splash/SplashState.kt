package com.focalors.hireai.ui.screen.splash

import com.focalors.hireai.data.remote.response.User

data class SplashState(
    val data: User? = null,
    val isLoading: Boolean = true,
    val isLoggedIn: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)