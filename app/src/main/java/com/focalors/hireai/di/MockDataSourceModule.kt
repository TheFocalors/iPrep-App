package com.focalors.hireai.di

import com.focalors.hireai.data.mock.MockInterviewDataSource
import com.focalors.hireai.data.mock.MockInterviewDataSourceImpl
import com.focalors.hireai.data.mock.MockJobDataSource
import com.focalors.hireai.data.mock.MockJobDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MockDataSourceModule {

    @Provides
    fun provideJobDataSource(): MockJobDataSource {
        return MockJobDataSourceImpl()
    }

    @Provides
    fun provideInterviewDataSource(): MockInterviewDataSource {
        return MockInterviewDataSourceImpl()
    }
}