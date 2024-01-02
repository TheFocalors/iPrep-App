package com.focalors.hireai.domain.repository

import com.focalors.hireai.data.remote.response.User
import com.focalors.hireai.data.remote.response.UserDataResponse
import com.focalors.hireai.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun loginUser(userEmail: String, password: String): Flow<Resource<UserDataResponse>>
    suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        passwordConfirmation: String,
    ): Flow<Resource<UserDataResponse>>
    suspend fun getLoggedInUser(): Flow<Resource<User>>
    suspend fun logOutUser(): Flow<Resource<Unit>>
}