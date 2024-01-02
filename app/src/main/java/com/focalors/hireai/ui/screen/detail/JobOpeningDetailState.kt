package com.focalors.hireai.ui.screen.detail

import com.focalors.hireai.data.remote.response.JobDetailResponse

data class JobOpeningDetailState(
    val job: JobDetailResponse? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)