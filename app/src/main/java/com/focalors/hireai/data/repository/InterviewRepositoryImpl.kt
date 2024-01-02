package com.focalors.hireai.data.repository

import com.focalors.hireai.data.local.UserPreferences
import com.focalors.hireai.data.mock.MockInterviewDataSource
import com.focalors.hireai.data.remote.ApiService
import com.focalors.hireai.data.remote.request.EndInterviewRequest
import com.focalors.hireai.data.remote.request.ReplyInterviewRequest
import com.focalors.hireai.data.remote.request.SaveInterviewRequest
import com.focalors.hireai.data.remote.request.StartInterviewRequest
import com.focalors.hireai.data.remote.response.EndInterviewResponse
import com.focalors.hireai.data.remote.response.InterviewHistoryResponse
import com.focalors.hireai.data.remote.response.ReplyInterviewResponse
import com.focalors.hireai.data.remote.response.StartInterviewResponse
import com.focalors.hireai.domain.repository.InterviewRepository
import com.focalors.hireai.utils.Resource
import com.focalors.hireai.utils.handleError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InterviewRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences,
    private val mockInterviewDataSource: MockInterviewDataSource
) : InterviewRepository {

//    override suspend fun sendMessage(): Flow<Resource<InterviewChat>> {
//        return flow {
//            try {
//                emit(Resource.Loading(true))
//                delay(3000)
//                val response = mockInterviewDataSource.sendMessage()
//                // val response = apiService.getAllJobs(authHeader)
//                // emit(Resource.Success(data = response.jobOpenings.map { it.toJobOpening() }))
//                emit(Resource.Success(data = response))
//            } catch (e: IOException) {
//                emit(Resource.Error("IO Exception: ${e.message}"))
//            } catch (e: TimeoutException) {
//                emit(Resource.Error("Timeout Exception: ${e.message}"))
//            } catch (e: HttpException) {
//                emit(Resource.Error("Http Exception: ${e.message}"))
//            }
//        }
//    }

//    override suspend fun startInterview(): Flow<Resource<InterviewChat>> {
//        return flow {
//            try {
//                emit(Resource.Loading(true))
//                delay(3000)
//                val response = mockInterviewDataSource.startInterview()
//                // val response = apiService.getAllJobs(authHeader)
//                // emit(Resource.Success(data = response.jobOpenings.map { it.toJobOpening() }))
//                emit(Resource.Success(data = response))
//            } catch (e: IOException) {
//                emit(Resource.Error("IO Exception: ${e.message}"))
//            } catch (e: TimeoutException) {
//                emit(Resource.Error("Timeout Exception: ${e.message}"))
//            } catch (e: HttpException) {
//                emit(Resource.Error("Http Exception: ${e.message}"))
//            }
//        }
//    }

    override suspend fun getInterviewHistories(): Flow<Resource<List<InterviewHistoryResponse>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.getInterviewHistories("Bearer $accessToken")
                    emit(Resource.Success(response.data))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun getInterviewHistory(id: String): Flow<Resource<InterviewHistoryResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.getInterviewHistory("Bearer $accessToken", id)
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun saveInterview(saveInterviewRequest: SaveInterviewRequest): Flow<Resource<InterviewHistoryResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.saveInterview("Bearer $accessToken", saveInterviewRequest)
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun startInterview(startInterviewRequest: StartInterviewRequest): Flow<Resource<StartInterviewResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.startInterview("Bearer $accessToken", startInterviewRequest)
                    // val response = StartInterviewResponse(data = ChatData("Hi"), sessionId = "ses", type = "Ai", job = null)
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun replyInterview(replyInterviewRequest: ReplyInterviewRequest): Flow<Resource<ReplyInterviewResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.replyInterview("Bearer $accessToken", replyInterviewRequest)
                    // val response = ReplyInterviewResponse(data = ChatData(content = "That great"), type = "ai", isDone = false)
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun endInterview(endInterviewRequest: EndInterviewRequest): Flow<Resource<EndInterviewResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val accessToken = userPreferences.getAccessToken().firstOrNull()
                if (accessToken != null) {
                    val response = apiService.endInterview("Bearer $accessToken", endInterviewRequest)
                    // val response = EndInterviewResponse(data = ChatData(content = "My Feedback is that you are the most bad interviewee that ive ever encounter"), type = "reviewer", isDone = true)
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error("Access token is null"))
                }
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

}