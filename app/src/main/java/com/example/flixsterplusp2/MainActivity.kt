package com.example.flixsterplusp2

import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, MovieFragment()).commit()

        val supportFragmentManager2 = supportFragmentManager
        val fragmentTransaction2 = supportFragmentManager2.beginTransaction()
        fragmentTransaction2.replace(R.id.content2, TvFragment()).commit()




    }
}