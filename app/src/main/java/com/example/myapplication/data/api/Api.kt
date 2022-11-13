package com.example.myapplication.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search/repositories?q=stars")
    suspend fun getRepositories(@Query("q") value: String): Response<ResponseParser>
}