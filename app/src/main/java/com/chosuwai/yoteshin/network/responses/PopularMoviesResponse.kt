package com.chosuwai.yoteshin.network.responses

import com.chosuwai.yoteshin.data.vos.PopularMoviesVO
import com.google.gson.annotations.SerializedName

class PopularMoviesResponse {

    @SerializedName("page")
    private val page: Int = 0

    @SerializedName("total_pages")
    private val totalPages: Int = 0

    @SerializedName("total_results")
    private val totalResults: Int = 0

    @SerializedName("results")
    private var results: List<PopularMoviesVO>? = null

    @SerializedName("status_message")
    private var statusMessage: String? = null

    fun getPage(): Int {
        return page
    }

    fun getTotalPages(): Int {
        return totalPages
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun getStatusMessage(): String? {
        return statusMessage
    }

    fun getMoviesList(): List<PopularMoviesVO> {
        if (results == null) {
            results = ArrayList<PopularMoviesVO>()
        }
        val resultsVal = results
        return resultsVal!!
    }


}
