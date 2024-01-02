package com.focalors.hireai.data.mock

import com.focalors.hireai.domain.model.InterviewChat

interface MockInterviewDataSource {
    suspend fun startInterview(): InterviewChat
    suspend fun sendMessage(): InterviewChat
}