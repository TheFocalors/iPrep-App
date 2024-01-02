package com.focalors.hireai.ui.screen.home

import com.focalors.hireai.data.remote.response.User

data class ProfileState(
    val profile: User? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)