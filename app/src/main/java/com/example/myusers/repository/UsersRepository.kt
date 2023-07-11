package com.example.myusers.repository

import com.example.myusers.api.ApiClient
import com.example.myusers.api.ApiInterface
import com.example.myusers.models.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsersRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getUsers():Response<UsersResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getUsers()
        }

    }

}