package br.com.rafaelsouza.testemovies.scenes.details


import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.ImageView
import br.com.rafaelsouza.testemovies.R
import br.com.rafaelsouza.testemovies.model.Genres


import br.com.rafaelsouza.testemovies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity(), DetailsInterface.View {


    private val presenter = DetailsPresenter(this)

    private var listGenres: ArrayList<Genres>? = null

    private var movie: Movie? = null

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

        //presenter.getGenres(getString(R.string.API_V3_MOVIES_KEY))

    }

    override fun getMoviesSuccess(movie: Movie) {
        initView(movie)
        progressBar.visibility = View.GONE
    }


    private fun initView(movie: Movie) {
        setPoster(movie.imagePath!!, posterMovieIMG)
        titleTXT.text = movie.title
        sinopeseTXT.text = movie.synopsis
        dateReleaseTXT.text = movie.dateRelease

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
                .into(imageView)


    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }


}
