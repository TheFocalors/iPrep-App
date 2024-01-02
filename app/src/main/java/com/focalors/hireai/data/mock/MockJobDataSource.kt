package com.focalors.hireai.data.mock

import com.focalors.hireai.domain.model.JobOpening

interface MockJobDataSource {
    suspend fun getAllJobs(): List<JobOpening>
}