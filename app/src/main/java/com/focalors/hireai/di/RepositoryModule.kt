package com.focalors.hireai.di

import com.focalors.hireai.data.repository.AuthRepositoryImpl
import com.focalors.hireai.data.repository.InterviewRepositoryImpl
import com.focalors.hireai.data.repository.IntroductionRepositoryImpl
import com.focalors.hireai.data.repository.JobRepositoryImpl
import com.focalors.hireai.domain.repository.AuthRepository
import com.focalors.hireai.domain.repository.InterviewRepository
import com.focalors.hireai.domain.repository.IntroductionRepository
import com.focalors.hireai.domain.repository.JobRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindJobRepository(
        jobRepositoryImpl: JobRepositoryImpl
    ): JobRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindInterviewRepository(
        interviewRepositoryImpl: InterviewRepositoryImpl
    ): InterviewRepository

    @Binds
    @Singleton
    abstract fun bindIntroductionRepository(
       introductionRepository: IntroductionRepositoryImpl
    ): IntroductionRepository
}