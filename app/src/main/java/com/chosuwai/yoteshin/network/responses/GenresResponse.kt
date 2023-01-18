package com.chosuwai.yoteshin.network.responses

import com.chosuwai.yoteshin.data.vos.GenresVO
import com.google.gson.annotations.SerializedName

class GenresResponse(

    @SerializedName("genres") var genresVO: List<GenresVO>
) {
    init {
        genresVO = ArrayList()
    }
}