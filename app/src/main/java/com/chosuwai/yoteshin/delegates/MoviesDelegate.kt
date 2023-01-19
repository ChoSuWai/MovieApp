package com.chosuwai.yoteshin.delegates

import com.chosuwai.yoteshin.data.vos.PopularMoviesVO

interface MoviesDelegate {

    fun onTapMovie(movie: PopularMoviesVO)
    fun onTapFavorite(movie: PopularMoviesVO)
}