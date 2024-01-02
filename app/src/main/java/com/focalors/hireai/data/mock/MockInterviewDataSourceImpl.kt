package com.focalors.hireai.data.mock

import com.focalors.hireai.domain.model.Author
import com.focalors.hireai.domain.model.InterviewChat
import javax.inject.Singleton

@Singleton
class MockInterviewDataSourceImpl : MockInterviewDataSource {
    override suspend fun startInterview(): InterviewChat {
        return InterviewChat(message = "Hi, Please introduce yourself", author = Author.Interviewer)
    }

    override suspend fun sendMessage(): InterviewChat {
        return InterviewChat(message = "That great", author = Author.Interviewer)
    }

}