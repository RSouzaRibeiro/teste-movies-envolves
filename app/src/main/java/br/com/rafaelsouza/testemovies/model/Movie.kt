package br.com.rafaelsouza.testemovies.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    val id: String? = null

    @SerializedName("original_title")
    val title: String? = null

    @SerializedName("overview")
    val synopsis: String? = null

    @SerializedName("popularity")
    val popularity: String? = null

    @SerializedName("video")
    val trailer: String? = null

    @SerializedName("vote_average")
    val media: String? = null

    @SerializedName("poster_path")
    val imagePath: String? = null

    @SerializedName("release_date")
    val dateRelease: String? = null

}