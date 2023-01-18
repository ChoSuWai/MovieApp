package com.chosuwai.yoteshin.data.models

import com.chosuwai.yoteshin.data.vos.GenresVO
import com.chosuwai.yoteshin.events.DataEvent
import com.chosuwai.yoteshin.network.responses.MoviesDataAgent
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MoviesAppModel : BaseModel() {

    companion object {
        //Singleton Design Pattern
        private var INSTANCE: MoviesAppModel? = null

        fun getInstance(): MoviesAppModel {
            if (INSTANCE == null) {
                INSTANCE = MoviesAppModel()
            }
            val i = INSTANCE
            return i!!
        }
    }

    private var mPage: Int = 1
    private var mGenres: HashMap<Int, GenresVO> = HashMap()

    fun loadPopularMovies() {
        MoviesDataAgent.getInstance().loadMovies(mPage)
        MoviesDataAgent.getInstance().loadGenres(MoviesAppConstants.API_KEY)
    }

    fun getGenresById(id: Int): String {
        return mGenres[id]!!.name
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onMoviesLoadedEvent(moviesLoadedEvent: DataEvent.MoviesLoadedEvent) {

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onGenresLoadedEvent(genresLoadedEvent: DataEvent.GenresLoadedEvent) {
        for (genres: GenresVO in genresLoadedEvent.loadedGenres) {
            mGenres[genres.id] = genres
        }
    }

}