package com.focalors.hireai.ui.screen.interview

import com.focalors.hireai.data.remote.response.ReplyInterviewResponse

data class InterviewState(
    val interview: List<ReplyInterviewResponse> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val isInterviewDone: Boolean = false,
    val isSaving: Boolean = false,
    val isEnding: Boolean = false,
)