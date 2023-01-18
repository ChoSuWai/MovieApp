package com.chosuwai.yoteshin.network

import com.chosuwai.yoteshin.network.responses.GenresResponse
import com.chosuwai.yoteshin.network.responses.PopularMoviesResponse
import com.chosuwai.yoteshin.utils.MoviesAppConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MoviesApi {

    companion object {
        const val PARAM_API_KEY = "api_key"
        const val PARAM_PAGE = "page"
    }

    @FormUrlEncoded
    @POST(MoviesAppConstants.POPULAR_MOVIES_END_POINT)
    fun loadMoviesList(
        @Field(PARAM_PAGE) page: Int
    ): Call<PopularMoviesResponse>

    @GET(MoviesAppConstants.GENRES_END_POINT)
    fun loadGenres(
        @Query(PARAM_API_KEY) apiKey: String
    ): Call<GenresResponse>

}