package com.example.pillikantest.repository

import com.example.pillikantest.api.RetrofitInstance
import com.example.pillikantest.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost() : Response<Post> {

        return RetrofitInstance.api.getPost()

    }

}