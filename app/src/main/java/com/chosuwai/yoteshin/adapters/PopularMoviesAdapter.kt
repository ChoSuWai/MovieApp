package com.chosuwai.yoteshin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.views.holders.PopularMoviesViewHolder

class PopularMoviesAdapter(context: Context) : RecyclerView.Adapter<PopularMoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val mLayoutInflator = LayoutInflater.from(parent.context)
        val popularMovieItemView =
            mLayoutInflator.inflate(R.layout.view_holder_popular_movies, parent, false)
        return PopularMoviesViewHolder(popularMovieItemView)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}