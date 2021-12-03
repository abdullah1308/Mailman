package com.example.mailman.repository

import com.example.mailman.api.RetrofitInstance
import model.MessageList

class Repository {

    suspend fun getMessageList(): MessageList {
        // TODO: pass user email as parameter
        return RetrofitInstance.api.getMessageList(null)
    }

}