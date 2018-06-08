package br.com.rafaelsouza.testemovies.scenes.main

import android.content.Context
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.model.Movies
import br.com.rafaelsouza.testemovies.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainInterface.View) : MainInterface.Presenter {
    override fun getAllMovies(param: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNowPlayngMovies(apiKey: String, page: String) {
        val call = RetrofitInitializer().noteService().getNowPlayngMovies(apiKey, page)

        call.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                view.displayError(t?.message.toString())
            }

            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                if (response!!.isSuccessful) {
                    val movies = response.body()
                    if (movies != null) view.getNowPlayngMoviesSuccess(movies)
                }
            }


        })


    }



}