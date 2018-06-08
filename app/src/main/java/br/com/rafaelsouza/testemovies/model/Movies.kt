package br.com.rafaelsouza.testemovies.model

import com.google.gson.annotations.SerializedName

class Movies {

    @SerializedName("results")
    val listMovies: ArrayList<Movie>?=null
}