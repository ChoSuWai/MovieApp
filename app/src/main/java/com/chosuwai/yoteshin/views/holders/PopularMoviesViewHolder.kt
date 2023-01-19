package com.chosuwai.yoteshin.views.holders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.data.models.MoviesAppModel
import com.chosuwai.yoteshin.data.vos.GenresVO
import com.chosuwai.yoteshin.data.vos.PopularMoviesVO
import com.chosuwai.yoteshin.delegates.MoviesDelegate
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import kotlinx.android.synthetic.main.view_holder_popular_movies.view.*

class PopularMoviesViewHolder<W>(itemView: View, private val mDelegate: MoviesDelegate) :
    BaseViewHolder<PopularMoviesVO>(itemView) {

    private var genresName: String = ""
    private var rating: Float = 3.5f

    override fun onClick(v: View?) {
        mDelegate.onTapMovie(mData)
    }

    override fun setData(data: PopularMoviesVO) {
        mData = data

        Glide.with(itemView.context)
            .load(MoviesAppConstants.IMAGE_ROOT_DIR + data.posterPath)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_loading)
            .into(itemView.ivMoviePoster)

        itemView.tvMovieTitle.text = data.title

        rating = ((data.voteAverage) / 2).toFloat()
        itemView.rbMovies.rating = rating
        Log.d("PopularMoviesViewHolder", "Rating : $rating")

        for (id in data.genreIds) {
            genresName = genresName + " " + MoviesAppModel.getInstance().getGenresById(id)
        }
        genresName = genresName.drop(1)
        Log.d("PopularMoviesViewHolder", "Genres Name : $genresName")

        itemView.tvGenres.text = genresName
        genresName = ""

    }
}