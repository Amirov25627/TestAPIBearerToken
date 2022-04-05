package com.example.testapplicationalmasamirov.network

import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: Login): Call<LoginResponse>

    @GET(Constants.PROFILE_URL)
    fun fetchProfile(@Header("Authorization") token: String): Call<PostsResponse>

}