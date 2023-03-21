package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flixsterplusp2.MOVIE_EXTRA
import com.example.flixsterplusp2.Movies
import com.example.flixsterplusp2.R

private const val TAG = "MovieDetail"

class MovieDetail : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var releaseTextView: TextView
    private lateinit var overviewTextView: TextView
    private lateinit var langTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mov_detail)

        titleTextView = findViewById(R.id.movTitle)
        releaseTextView = findViewById(R.id.movRelease)
        overviewTextView = findViewById(R.id.movOverview)
        langTextView = findViewById(R.id.movLang)

        /* val mov = intent.getSerializableExtra(MOVIE_EXTRA) as Movies

        titleTextView.text = mov.movieTitle
        releaseTextView.text = mov.movRelDate
        overviewTextView.text = mov.movieDescription
        langTextView.text = mov.movOrigLang */


    }
}