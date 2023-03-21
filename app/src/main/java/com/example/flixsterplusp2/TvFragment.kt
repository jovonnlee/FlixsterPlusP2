package com.example.flixsterplusp2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.flixsterplusp2.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONObject

private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

class TvFragment : Fragment(), OnListFragmentInteractionsListenerShows {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tv_view_list, container, false)
        val recyclerView = view.findViewById<View>(R.id.bottomRv) as RecyclerView
        val context = view.context

        recyclerView.layoutManager = GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false)
        updateAdapter(recyclerView)
        return view
    }
    private fun updateAdapter(recyclerView: RecyclerView) {
        val client = AsyncHttpClient()
        val params = RequestParams()

        params["api-key"] = API_KEY


        client [
                " https://api.themoviedb.org/3/tv/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1",
                params,

                object : JsonHttpResponseHandler()


                {
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Headers,
                        json: JsonHttpResponseHandler.JSON
                    ) {
                        val arrayMovieType = object : TypeToken<List<TvShows>>() {}.type
                        val resultsJSON = json.jsonObject.getJSONArray("results")
                        val tvsRawJSON: String = resultsJSON.toString()
                        val gson = Gson()
                        val models: List<TvShows> = gson.fromJson(tvsRawJSON, arrayMovieType)
                        recyclerView.adapter = ShowRecyclerViewAdapter(models, this@TvFragment)

                        Log.d("TvFragment", "response successful")
                    }

                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        errorResponse: String,
                        t: Throwable?

                    ) {
                        t?.message?.let {
                            Log.e("MovieFragment", errorResponse) }
                    }
                }]
    }

    override fun onItemClick(item: TvShows) {
        Toast.makeText(context, "test: " + item.showName, Toast.LENGTH_LONG).show()
    }
}