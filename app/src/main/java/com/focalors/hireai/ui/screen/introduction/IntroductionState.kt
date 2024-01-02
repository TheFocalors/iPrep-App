package com.focalors.hireai.ui.screen.introduction

data class IntroductionDataState<T>(
    val data: T? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false,
)