package com.cliffdevops.recipesapp.controller

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cliffdevops.recipesapp.MainActivity
import com.cliffdevops.recipesapp.R
import com.cliffdevops.recipesapp.model.RecipeModel
import com.squareup.picasso.Picasso

class RecipesAdapter(mainActivity: MainActivity) :
    RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipeList: List<RecipeModel>? = null

    fun setRecipeList(recipeList: List<RecipeModel>) {
        this.recipeList = recipeList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int

    ): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recipeviewlayout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.i("data", "List size: " + recipeList?.size)
        holder.bind(recipeList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (recipeList == null)
            0
        else
            recipeList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val calories: TextView = view.findViewById(R.id.txtCalories)
        val carbos: TextView = view.findViewById(R.id.txtCarbos)
        val description: TextView = view.findViewById(R.id.txtDescription)
        val difficulty: TextView = view.findViewById(R.id.txtDiffcult)
        val fats: TextView = view.findViewById(R.id.txtfat)
        val headline: TextView = view.findViewById(R.id.txtHeading)
        val id: TextView = view.findViewById(R.id.txtId)
        val name: TextView = view.findViewById(R.id.txtName)
        val proteins: TextView = view.findViewById(R.id.txtProtain)
        val posttime: TextView = view.findViewById(R.id.txtTime)
        val thumb: ImageView = view.findViewById(R.id.thumbImageView)
        val image: ImageView = view.findViewById(R.id.recipeImageView)

        fun bind(data: RecipeModel) {
            calories.text = data.calories
            carbos.text = data.carbos
            description.text = data.description
            difficulty.text = data.difficulty
            fats.text = data.fats
            headline.text = data.headline
            id.text = data.id
            proteins.text = data.proteins
            posttime.text = data.time
            Picasso.get().load(data.thumb)
                .into(thumb);
            Picasso.get().load(data.image)
                .into(image);

        }
    }
}