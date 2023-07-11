package com.example.myusers.api

import com.example.myusers.models.User
import com.example.myusers.models.UsersResponse
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    suspend fun getUsers():Response<UsersResponse>

    @GET("/users{id}")
    suspend fun getUsers(@Path("id")userId:Int):Response<User>

}