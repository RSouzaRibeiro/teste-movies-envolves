package br.com.rafaelsouza.testemovies.scenes.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import br.com.rafaelsouza.testemovies.R
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.model.Movies
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainInterface.View {


    private var inFilter = false
    private var searchItem: MenuItem? = null
    private var searchView: SearchView? = null

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        getMovies()
        swipeRefreshConfig()
        initSearchView()


    }

    private fun setListners() {

       

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_movies, menu)

        return super.onCreateOptionsMenu(menu)
    }


    private fun initToolbar() {

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun getMovies() {
        presenter.getNowPlayngMovies(getString(R.string.API_V3_MOVIES_KEY), "1")
    }


    private fun swipeRefreshConfig() {

        swipeRefresh.setOnRefreshListener {

            if (!inFilter) getMovies()
            else swipeRefresh.isRefreshing = false
        }
    }

    override fun getNowPlayngMoviesSuccess(movies: Movies) {
        if (movies.listMovies != null) {
            initRecycleView(movies.listMovies)
            swipeRefresh.isRefreshing = false
        }
    }

    private fun initSearchView() {
        val view = searchView?.findViewById<View>(android.support.v7.appcompat.R.id.search_plate)
        view?.setBackgroundColor(resources.getColor(R.color.white))
        searchView?.queryHint = resources.getString(R.string.label_movies_search)

        //setSearchListeners()
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun initRecycleView(result: ArrayList<Movie>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainAdapter(this, result)


    }
}
