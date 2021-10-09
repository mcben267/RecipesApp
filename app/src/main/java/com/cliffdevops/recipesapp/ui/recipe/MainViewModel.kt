package com.cliffdevops.recipesapp.ui.recipe

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cliffdevops.recipesapp.model.RecipeModel
import com.cliffdevops.recipesapp.model.retrofit.RetroInstance
import com.cliffdevops.recipesapp.model.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var liveDataList: MutableLiveData<List<RecipeModel>> = MutableLiveData()


    fun getLiveDataObserver(): MutableLiveData<List<RecipeModel>> {
        return this.liveDataList
    }

    fun getRecipes() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getRecipesList()

        call.enqueue(object : Callback<List<RecipeModel>> {

            override fun onResponse(
                call: Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                //showData()
                liveDataList.postValue(null)
                Log.i("recipelog", "Success recipe Name: ${response.body()!![0].image}")
            }

            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {
                liveDataList.postValue(null)
                Log.i("data", "Failed ${t.message}")
            }
        })
    }

    fun showData(recipeList: List<RecipeModel>) {
        //recyclerView.apply{

    }
}