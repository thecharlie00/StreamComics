package com.example.streamcomics.hangmanGame

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIhangman {
    @GET("/new")
    fun getNewWord(@Query("lang") lang: String, @Query("maxTries") maxTries: Int?=null): Call<HangmanModel>

    @POST("/guess")
    fun guessLetter(@Body body: Map<String, String?>): Call<HangmanModel>
}