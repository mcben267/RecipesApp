package com.cliffdevops.recipesapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cliffdevops.recipesapp.controller.RecipesAdapter
import com.cliffdevops.recipesapp.databinding.ActivityMainBinding
import com.cliffdevops.recipesapp.model.RecipeModel
import com.cliffdevops.recipesapp.model.retrofit.RetroInstance
import com.cliffdevops.recipesapp.model.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recipesAdapter: RecipesAdapter
    private lateinit var recipeList: List<RecipeModel>
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recipesAdapter = RecipesAdapter(this)
        recyclerView.adapter = recipesAdapter

        getRecipes()

    }


    private fun getRecipes() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getRecipesList()

        call.enqueue(object : Callback<List<RecipeModel>> {

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                //showData(response.body()!!)
                recipeList = response.body()!!

                recipesAdapter.setRecipeList(recipeList)
                recipesAdapter.notifyDataSetChanged()


                Log.i("recipelog", "Success recipe Name: ${response.body()!![0].name}")
            }

            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {
                // liveDataList.postValue(null)
                Log.i("data", "Failed ${t.message}")
            }
        })
    }


}
