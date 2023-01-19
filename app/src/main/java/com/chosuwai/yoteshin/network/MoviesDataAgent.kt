package com.chosuwai.yoteshin.network

import android.util.Log
import com.chosuwai.yoteshin.events.DataEvent
import com.chosuwai.yoteshin.events.ErrorEvent
import com.chosuwai.yoteshin.network.responses.GenresResponse
import com.chosuwai.yoteshin.network.responses.PopularMoviesResponse
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MoviesDataAgent {

    companion object {
        //Singleton Design Pattern
        private var INSTANCE: MoviesDataAgent? = null

        fun getInstance(): MoviesDataAgent {
            if (INSTANCE == null) {
                INSTANCE = MoviesDataAgent()
            }
            val i = INSTANCE
            return i!!
        }
    }

    private val mMoviesApi: MoviesApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(MoviesAppConstants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()

        mMoviesApi = retrofit.create(MoviesApi::class.java)
    }

    fun loadMovies(page: Int) {
        val moviesResponseCall = mMoviesApi.loadMoviesList(page)
        moviesResponseCall.enqueue(object : Callback<PopularMoviesResponse> {
            override fun onResponse(
                call: Call<PopularMoviesResponse>,
                response: Response<PopularMoviesResponse>
            ) {
                val moviesResponse: PopularMoviesResponse? = response.body()
                if (moviesResponse != null && moviesResponse.getMoviesList().isNotEmpty()) {
                    val moviesLoadedEvent = DataEvent.MoviesLoadedEvent(
                        moviesResponse.getPage(),
                        moviesResponse.getMoviesList()
                    )
                    EventBus.getDefault().post(moviesLoadedEvent)
                } else {
                    if (moviesResponse != null)
                        EventBus.getDefault()
                            .post(DataEvent.EmptyDataLoadedEvent(moviesResponse.getStatusMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

        })
    }

    fun loadGenres(apiKey: String) {
        val genresResponseCall = mMoviesApi.loadGenres(apiKey)
        genresResponseCall.enqueue(object : Callback<GenresResponse> {
            override fun onResponse(
                call: Call<GenresResponse>,
                response: Response<GenresResponse>
            ) {
                val genresResponse: GenresResponse? = response.body()
                if (genresResponse != null) {
                    val genresLoadedEvent = DataEvent.GenresLoadedEvent(genresResponse.genresVO)
                    Log.d("MoviesDataAgent", "Genres : ${genresResponse.genresVO.size}")
                    EventBus.getDefault().post(genresLoadedEvent)
                }
            }

            override fun onFailure(call: Call<GenresResponse>, t: Throwable) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }


        })
    }

}