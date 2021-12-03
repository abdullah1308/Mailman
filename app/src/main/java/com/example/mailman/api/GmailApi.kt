package com.example.mailman.api

import model.MessageList
import retrofit2.http.GET
import retrofit2.http.Path

interface GmailApi {

    @GET("{userId}/messages")
    suspend fun getMessageList(
        @Path("userId") email: String?
    ): MessageList
}