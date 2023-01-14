package com.chosuwai.yoteshin.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.adapters.PopularMoviesAdapter
import kotlinx.android.synthetic.main.activity_popular_movies.*

class PopularMoviesActivity : BaseActivity() {

    private var mPopularMoviesAdapter: PopularMoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        rvMovies.layoutManager = LinearLayoutManager(applicationContext)
        mPopularMoviesAdapter = PopularMoviesAdapter(applicationContext)
        rvMovies.adapter = mPopularMoviesAdapter
    }

}