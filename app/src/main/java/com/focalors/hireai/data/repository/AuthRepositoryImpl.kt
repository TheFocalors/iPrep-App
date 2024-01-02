package com.focalors.hireai.data.repository

import com.focalors.hireai.data.local.UserPreferences
import com.focalors.hireai.data.remote.ApiService
import com.focalors.hireai.data.remote.request.LoginRequest
import com.focalors.hireai.data.remote.request.LogoutRequest
import com.focalors.hireai.data.remote.request.RegisterRequest
import com.focalors.hireai.data.remote.response.User
import com.focalors.hireai.data.remote.response.UserDataResponse
import com.focalors.hireai.domain.repository.AuthRepository
import com.focalors.hireai.utils.Resource
import com.focalors.hireai.utils.handleError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
): AuthRepository {
    override suspend fun loginUser(
        userEmail: String,
        password: String
    ): Flow<Resource<UserDataResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val loginData = LoginRequest(userEmail, password)
                val response = apiService.loginUser(loginData)
                userPreferences.saveAccessToken(response.access.token)
                userPreferences.saveRefreshToken(response.refresh.token)
                emit(Resource.Success(response))
            } catch (e: Throwable) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }

    override suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        passwordConfirmation: String,
    ): Flow<Resource<UserDataResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val registerData = RegisterRequest(
                    firstName,
                    lastName,
                    email,
                    password,
                    passwordConfirmation,
                    true
                )
                val response = apiService.registerUser(registerData)
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(handleError(e)))
            }
        }
    }


    override suspend fun getLoggedInUser(): Flow<Resource<User>> {
        val token = userPreferences.getAccessToken().firstOrNull()
        return flow {
            if (token != null) {
                try {
                    val response = apiService.getLoggedInUser("Bearer $token")
                    emit(Resource.Success(response))
                } catch (e: Exception) {
                    emit(Resource.Error(handleError(e)))
                }
            } else {
                emit(Resource.Error("Unauthorized: No Token"))
            }
        }
    }

    override suspend fun logOutUser(): Flow<Resource<Unit>> {
        val token = userPreferences.getRefreshToken().firstOrNull()
        return flow {
            if (token != null) {
                try {
                    val response = apiService.logOutUser(LogoutRequest(token))
                    userPreferences.clearTokens()
                    emit(Resource.Success(response))
                } catch (e: Exception) {
                    emit(Resource.Error(handleError(e)))
                }
            } else {
                emit(Resource.Error("Unauthorized: No Token"))
            }
        }
    }
}