package com.chosuwai.yoteshin.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chosuwai.yoteshin.R
import com.chosuwai.yoteshin.adapters.PopularMoviesAdapter
import com.chosuwai.yoteshin.data.models.MoviesAppModel
import com.chosuwai.yoteshin.delegates.MoviesDelegate
import com.chosuwai.yoteshin.events.DataEvent
import kotlinx.android.synthetic.main.activity_popular_movies.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class PopularMoviesActivity : BaseActivity(), MoviesDelegate {

    private var mPopularMoviesAdapter: PopularMoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        rvMovies.layoutManager = LinearLayoutManager(applicationContext)
        mPopularMoviesAdapter = PopularMoviesAdapter(applicationContext, this)
        rvMovies.adapter = mPopularMoviesAdapter

        MoviesAppModel.getInstance().loadPopularMovies()
        swipeRefreshLayout.isRefreshing = true
    }

    override fun onTapMovie() {
        val intent = MovieDetailsActivity.newIntent(applicationContext)
        startActivity(intent)
    }

    override fun onTapFavorite() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMoviesLoadedEvent(moviesLoadedEvent: DataEvent.MoviesLoadedEvent) {
        mPopularMoviesAdapter!!.setData(moviesLoadedEvent.loadedMovies)
        swipeRefreshLayout.isRefreshing = false
    }

}