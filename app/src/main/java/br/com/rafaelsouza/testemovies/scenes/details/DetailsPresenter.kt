package br.com.rafaelsouza.testemovies.scenes.details

import br.com.rafaelsouza.testemovies.model.Genres
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPresenter(val view: DetailsInterface.View): DetailsInterface.Presenter {
    override fun getGenres(apiKey: String) {
        val call = RetrofitInitializer().noteService().getGenres(apiKey)

        call.enqueue(object : Callback<ArrayList<Genres>>{
            override fun onFailure(call: Call<ArrayList<Genres>>?, t: Throwable?) {
                view.displayError(t?.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Genres>>?, response: Response<ArrayList<Genres>>?) {
               if(response!=null){
                   val listGenres = response.body()
                   if(listGenres!=null){
                       view.getGenresSuccess(listGenres)
                   }
               }
            }

        })
    }

    override fun getMoviesById(id: String, apiKey: String) {
        val call = RetrofitInitializer().noteService().getMovieById(id, apiKey)

        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                view.displayError(t?.message.toString())
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {

                if (response != null) {
                    val movie = response.body()
                    view.getMoviesSuccess(movie!!)
                }

            }

        })
    }
}