package com.example.flixsterplusp2

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.codepath.articlesearch.MovieDetail

class MovieRecyclerViewAdapter(
    private val movs: List<Movies>,
    private val mListener: OnListFragmentInteractionsListenerMovies,

    var onItemClick : ((Movies) -> Unit)? = null
)
    : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view, parent, false)
        return MovieViewHolder(view)

    }
    inner class MovieViewHolder(val mView: View) :RecyclerView.ViewHolder(mView), View.OnClickListener {
        var mItem: Movies? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movieTitle) as TextView
        val mPict: ImageView = mView.findViewById<View>(R.id.imageView) as ImageView

        init {
            mView.setOnClickListener(this)
        }

        override fun toString(): String {
            return mMovieTitle.toString() + " '"
        }

        override fun onClick(v: View?) {
            Toast.makeText(v?.context, "yeas", Toast.LENGTH_LONG).show()

        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movs[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.movieTitle


        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/"+movie.movieImage)
            .centerInside()
            .transform(RoundedCorners(30))
            .into(holder.mPict)

        holder.mView.setOnClickListener {
            onItemClick?.invoke(movie)
            holder.mItem?.let { movie -> mListener?.onItemClick(movie)

            }
        }
    }
    override fun getItemCount(): Int {
        return movs.size
    }

}