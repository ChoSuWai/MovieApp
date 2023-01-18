package com.chosuwai.yoteshin.data.vos

import com.google.gson.annotations.SerializedName

class PopularMoviesVO(
    @SerializedName("adult") var adult: String = "",
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("genre_ids") var genreIds: List<Int> = ArrayList(),
    @SerializedName("id") var id: String = "",
    @SerializedName("original_language") var originalLanguage: String = "",
    @SerializedName("original_title") var originalTitle: String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("popularity") var popularity: Double = 9137.939,
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("video") var video: Boolean = false,
    @SerializedName("vote_average") var voteAverage: Double = 7.3,
    @SerializedName("vote_count") var voteCount: Int = 2296
)