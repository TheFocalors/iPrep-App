package com.focalors.hireai.ui.screen.history

import com.focalors.hireai.data.remote.response.InterviewHistoryResponse

data class InterviewHistoryListState(
    val interviews: List<InterviewHistoryResponse> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)