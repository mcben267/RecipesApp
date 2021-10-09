package com.cliffdevops.recipesapp.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        fun getRetroInstance(): Retrofit {
            val baseUrl = "https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/"
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}