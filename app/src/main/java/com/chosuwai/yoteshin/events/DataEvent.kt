package com.chosuwai.yoteshin.events

import com.chosuwai.yoteshin.data.vos.GenresVO
import com.chosuwai.yoteshin.data.vos.PopularMoviesVO

class DataEvent {

    open class MoviesLoadedEvent(val pageIndex: Int, val loadedMovies: List<PopularMoviesVO>)

    open class GenresLoadedEvent(val loadedGenres: List<GenresVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Data Response")


}