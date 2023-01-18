package com.chosuwai.yoteshin.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.data.vos.PopularMoviesVO
import com.chosuwai.yoteshin.delegates.MoviesDelegate
import com.chosuwai.yoteshin.views.holders.PopularMoviesViewHolder

class PopularMoviesAdapter(context: Context, private val mDelegate: MoviesDelegate) :
    RecyclerView.Adapter<PopularMoviesViewHolder<PopularMoviesVO>>() {

    var mMoviesList: List<PopularMoviesVO> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesViewHolder<PopularMoviesVO> {
        val mLayoutInflator = LayoutInflater.from(parent.context)
        val popularMovieItemView =
            mLayoutInflator.inflate(R.layout.view_holder_popular_movies, parent, false)
        return PopularMoviesViewHolder(popularMovieItemView, mDelegate)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder<PopularMoviesVO>, position: Int) {
        holder.setData(mMoviesList[position])
    }

    override fun getItemCount(): Int {
        return mMoviesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<PopularMoviesVO>) {
        mMoviesList = data
        notifyDataSetChanged()
    }
}