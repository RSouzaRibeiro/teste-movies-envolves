package br.com.rafaelsouza.testemovies.scenes.details

import br.com.rafaelsouza.testemovies.model.Genres
import br.com.rafaelsouza.testemovies.model.Movie

interface DetailsInterface {

    interface View{
        fun getMoviesSuccess(movie: Movie)
        fun displayError(message: String)
        fun getGenresSuccess(genres: ArrayList<Genres>)
    }

    interface Presenter{
        fun getMoviesById(id:String, apiKey: String)
        fun getGenres(apiKey: String)
    }
}