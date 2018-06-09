package br.com.rafaelsouza.testemovies.scenes.details


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import android.view.View
import android.widget.ImageView
import br.com.rafaelsouza.testemovies.R
import br.com.rafaelsouza.testemovies.model.Genres


import br.com.rafaelsouza.testemovies.model.Movie
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity(), DetailsInterface.View {


    private val presenter = DetailsPresenter(this)
    private var listGenres: ArrayList<Genres>? = null

    companion object {
        var MOVIE_ID = "movieId"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        progressBar.visibility = View.VISIBLE
        intent.extras.get(MOVIE_ID)?.let {
            presenter.getMoviesById(it.toString(), getString(R.string.API_V3_MOVIES_KEY))
        }

        initToolbar()


    }


    override fun getMoviesSuccess(movie: Movie) {
        initView(movie)
        progressBar.visibility = View.GONE
    }

    private fun initToolbar() {

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }




    private fun initView(movie: Movie) {
        setPoster(movie.imagePath!!, posterMovieIMG)
        titleTXT.text = movie.title
        sinopeseTXT.text = movie.synopsis
        dateReleaseTXT.text = movie.dateRelease
        mediaTXT.text = movie.media

    }

    override fun displayError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenresSuccess(genres: ArrayList<Genres>) {
        listGenres = genres
    }

    private fun setPoster(urlPath: String, imageView: ImageView) {
        Picasso.with(this)
                .load(getString(R.string.PATH_GET_IMAGE) + urlPath)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }


}
