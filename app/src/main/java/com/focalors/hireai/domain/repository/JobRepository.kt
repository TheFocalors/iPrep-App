package com.focalors.hireai.domain.repository

import androidx.paging.PagingData
import com.focalors.hireai.data.remote.response.JobDetailResponse
import com.focalors.hireai.data.remote.response.JobOpeningResponse
import com.focalors.hireai.utils.Resource
import kotlinx.coroutines.flow.Flow

interface JobRepository {
    suspend fun searchJobs(q: String): Flow<Resource<List<JobOpeningResponse>>>
    suspend fun getAllJobs(
        categoryFilter: String?,
        cityFilter: String?,
        companyFilter: String?,
        salaryFromFilter: String?,
        salaryToFilter: String?,
        skillRequirementsFilter: String?,
        limit: Int?,
        page: Int?,
        sortBy: String?
    ): Flow<Resource<List<JobOpeningResponse>>>

    suspend fun getRecommendedJobs(
        categoryFilter: String?,
        cityFilter: String?,
        companyFilter: String?,
        salaryFromFilter: String?,
        salaryToFilter: String?,
        skillRequirementsFilter: String?,
        limit: Int?,
        page: Int?,
        sortBy: String?
    ): Flow<Resource<List<JobOpeningResponse>>>

    suspend fun getJobById(jobId: String): Flow<Resource<JobDetailResponse>>
    fun getAllJobsWithPaging(
        categoryFilter: String?,
        cityFilter: String?,
        companyFilter: String?,
        salaryFromFilter: String?,
        salaryToFilter: String?,
        skillRequirementsFilter: String?,
        limit: Int?,
        page: Int?,
        sortBy: String?
    ): Flow<PagingData<JobOpeningResponse>>
}
