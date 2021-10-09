package com.cliffdevops.recipesapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cliffdevops.recipesapp.model.RecipeModel
import com.cliffdevops.recipesapp.model.retrofit.RetroInstance
import com.cliffdevops.recipesapp.model.retrofit.RetroServiceInterface
import com.cliffdevops.recipesapp.ui.recipe.RecipeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: RecipeActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_activity)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipeFragment.newInstance())
                .commitNow()
        }
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
                Log.i("recipelog", "Success recipe Name: ${response.body()!![0].image}")
            }

            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {
                // liveDataList.postValue(null)
                Log.i("data", "Failed ${t.message}")
            }
        })
    }

    fun showData(recipeList: List<RecipeModel>) {
        //recyclerView.apply{

    }

}