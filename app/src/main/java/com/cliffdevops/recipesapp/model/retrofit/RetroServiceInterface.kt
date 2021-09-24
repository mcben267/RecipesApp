package com.cliffdevops.recipesapp.model.retrofit

import com.cliffdevops.recipesapp.model.RecipeModel
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface  {
    @GET("/recipes.json")
    @FormUrlEncoded
    fun getRecipesList(): Call<List<RecipeModel>>
}