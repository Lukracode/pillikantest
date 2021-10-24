package com.example.pillikantest.api

import com.example.pillikantest.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("./auth")
    suspend fun getPost(): Response<Post>

}