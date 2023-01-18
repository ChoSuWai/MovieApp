package com.chosuwai.yoteshin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chosuwai.yoteshin.R

class MovieDetailsActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}