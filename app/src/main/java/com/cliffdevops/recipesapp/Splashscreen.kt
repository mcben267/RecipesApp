package com.cliffdevops.recipesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        thread {
            Thread.sleep(3000)
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}