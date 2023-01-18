package com.chosuwai.yoteshin.data.vos

import com.google.gson.annotations.SerializedName

class GenresVO (
    @SerializedName("id") var id: Int = 10751,
    @SerializedName("name") var name: String = "Family"
        )