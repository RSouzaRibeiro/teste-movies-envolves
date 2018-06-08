package br.com.rafaelsouza.testemovies.scenes.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.rafaelsouza.testemovies.R
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.model.Movies
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainInterface.View {



    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // presenter.getMoviesById("76341", getString(R.string.API_V3_MOVIES_KEY))
        presenter.getNowPlayngMovies(getString(R.string.API_V3_MOVIES_KEY), "1")


    }



    override fun getNowPlayngMoviesSuccess(movies: Movies) {
        if(movies.listMovies!=null)  initRecycleView(movies.listMovies)
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun initRecycleView(result: ArrayList<Movie>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainAdapter(this, result)

        
    }
}
