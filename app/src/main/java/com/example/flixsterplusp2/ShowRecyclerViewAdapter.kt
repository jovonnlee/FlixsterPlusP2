package com.example.flixsterplusp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class ShowRecyclerViewAdapter(
    private val tvs: List<TvShows>,
    private val mListener: OnListFragmentInteractionsListenerShows?
)
    : RecyclerView.Adapter<ShowRecyclerViewAdapter.ShowsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tv_view, parent, false)
        return ShowsViewHolder(view)

    }

    inner class ShowsViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: TvShows? = null
        val mShowTitle: TextView = mView.findViewById<View>(R.id.showTitle) as TextView
        // val mShowDescrip: TextView = mView.findViewById<View>(R.id.movieDescription) as TextView
        val mPict: ImageView = mView.findViewById<View>(R.id.imageView2) as ImageView

        override fun toString(): String {
            return mShowTitle.toString() + " '"
        }
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {

        val show = tvs[position]

        holder.mItem = show
        holder.mShowTitle.text = show.showName
        // holder.mShowsDescrip.text = show.movieDescription



        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/" + show.showImage)
            .centerInside()
            .transform(RoundedCorners(30))
            .into(holder.mPict)

        holder.mView.setOnClickListener {
            holder.mItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return tvs.size
    }

}