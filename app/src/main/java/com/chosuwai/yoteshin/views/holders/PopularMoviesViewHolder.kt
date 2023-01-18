package com.chosuwai.yoteshin.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.data.models.MoviesAppModel
import com.chosuwai.yoteshin.data.vos.PopularMoviesVO
import com.chosuwai.yoteshin.delegates.MoviesDelegate
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import kotlinx.android.synthetic.main.view_holder_popular_movies.view.*

class PopularMoviesViewHolder<W>(itemView: View, private val mDelegate: MoviesDelegate) :
    BaseViewHolder<PopularMoviesVO>(itemView) {

    private var genresList: List<String> = ArrayList()
    private var genresName: String = ""

    override fun onClick(v: View?) {
        mDelegate.onTapMovie()
    }

    override fun setData(data: PopularMoviesVO) {
        mData = data

        Glide.with(itemView.context)
            .load(MoviesAppConstants.IMAGE_ROOT_DIR + data.posterPath)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_loading)
            .into(itemView.ivMoviePoster)

        itemView.tvMovieTitle.text = data.title
        itemView.rbMovies.rating = ((data.voteAverage) / 2).toFloat()

        for (id in data.genreIds) {
            genresList = genresList + MoviesAppModel.getInstance().getGenresById(id)
        }

        /*
        for (name in genresList) {
            genresName = genresName + " " + name
        }
        itemView.tvGenres.text = genresName
         */

        itemView.tvGenres.text = genresList.toString()

    }
}