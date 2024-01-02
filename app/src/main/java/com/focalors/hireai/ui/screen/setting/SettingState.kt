package com.focalors.hireai.ui.screen.setting

data class SettingState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isLoggedOut: Boolean = false,
    val errorMessage: String? = null
)