package com.junjange.remote.model.error

interface ErrorResponse {
    val success: Boolean
    val status: Int
    val code: String
    val reason: String
    val time_stamp: String
    val path: String
}