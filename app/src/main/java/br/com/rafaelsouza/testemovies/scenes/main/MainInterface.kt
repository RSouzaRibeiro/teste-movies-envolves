package br.com.rafaelsouza.testemovies.scenes.main

import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.model.Movies

interface MainInterface {

    interface  View{

        fun displayError(message: String)
        fun getNowPlayngMoviesSuccess(movies: Movies)
    }

    interface Presenter{

        fun getAllMovies(param: String)
        fun getNowPlayngMovies(apiKey: String, page:String)
    }
}