package com.focalors.hireai.domain.model

data class InterviewChat(
    val message: String,
    val author: Author
)

enum class Author {
    User,
    Interviewer
}