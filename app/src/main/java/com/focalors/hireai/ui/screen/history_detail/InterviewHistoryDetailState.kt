package com.focalors.hireai.ui.screen.history_detail

import com.focalors.hireai.data.remote.response.InterviewHistoryResponse
import com.focalors.hireai.data.remote.response.ReplyInterviewResponse

data class InterviewHistoryDetailState(
    val interviews: InterviewHistoryResponse? = null,
    val chatHistory: List<ReplyInterviewResponse> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val isInterviewDone: Boolean = false,
)