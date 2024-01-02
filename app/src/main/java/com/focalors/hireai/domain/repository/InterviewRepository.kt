package com.focalors.hireai.domain.repository

import com.focalors.hireai.data.remote.request.EndInterviewRequest
import com.focalors.hireai.data.remote.request.ReplyInterviewRequest
import com.focalors.hireai.data.remote.request.SaveInterviewRequest
import com.focalors.hireai.data.remote.request.StartInterviewRequest
import com.focalors.hireai.data.remote.response.EndInterviewResponse
import com.focalors.hireai.data.remote.response.InterviewHistoryResponse
import com.focalors.hireai.data.remote.response.ReplyInterviewResponse
import com.focalors.hireai.data.remote.response.StartInterviewResponse
import com.focalors.hireai.utils.Resource
import kotlinx.coroutines.flow.Flow

interface InterviewRepository {
    suspend fun getInterviewHistories(): Flow<Resource<List<InterviewHistoryResponse>>>
    suspend fun getInterviewHistory(id: String): Flow<Resource<InterviewHistoryResponse>>
    suspend fun saveInterview(saveInterviewRequest: SaveInterviewRequest): Flow<Resource<InterviewHistoryResponse>>
    suspend fun startInterview(startInterviewRequest: StartInterviewRequest): Flow<Resource<StartInterviewResponse>>
    suspend fun replyInterview(replyInterviewRequest: ReplyInterviewRequest): Flow<Resource<ReplyInterviewResponse>>
    suspend fun endInterview(endInterviewRequest: EndInterviewRequest): Flow<Resource<EndInterviewResponse>>
}