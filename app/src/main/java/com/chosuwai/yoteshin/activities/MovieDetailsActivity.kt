package com.chosuwai.yoteshin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.data.models.MoviesAppModel
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.view_holder_popular_movies.view.*

class MovieDetailsActivity : BaseActivity() {

    private var genresName: String = ""

    companion object {
        const val IE_MOVIE_ID = "IE_MOVIE_ID"

        fun newIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(IE_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieId = intent.getStringExtra(IE_MOVIE_ID)
        val movie = MoviesAppModel.getInstance().getMoviesById(movieId)
        if (movie != null) {
            Glide.with(applicationContext)
                .load(MoviesAppConstants.IMAGE_ROOT_DIR + movie.backdropPath)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_loading)
                .into(ivBackdrop)

            tvMovieTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate
            tvLanguage.text = movie.originalLanguage
            tvRating.text = (movie.voteAverage / 2).toString()
            tvVotes.text = movie.voteCount.toString()
            tvAboutMovie.text = movie.overview

            for (id in movie.genreIds) {
                genresName = genresName + " " + MoviesAppModel.getInstance().getGenresById(id)
            }
            genresName = genresName.drop(1)
            Log.d("PopularMoviesViewHolder", "Genres Name : $genresName")

            tvGenres.text = genresName
            genresName = ""

        }
    }
}