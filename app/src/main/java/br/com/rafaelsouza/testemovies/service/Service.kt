package br.com.rafaelsouza.testemovies.service

import br.com.rafaelsouza.testemovies.model.Genres
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class Service {


    interface NoteService {

        @GET("forecast/locale/{id}/days/{days}?")
        fun getAllMovies(@Path("id") id: String, @Path("days") days: String, @Query("token") token: String): Call<Movie>

        @GET("movie/now_playing?")
        fun getNowPlayngMovies(@Query("api_key") api_key: String, @Query("page") page: String): Call<Movies>

        @GET("movie/{id}")
        fun getMovieById(@Path("id") id: String, @Query("api_key") token: String): Call<Movie>

        @GET("genre/movie/list?")
        fun getGenres(@Query("api_key") token: String): Call<ArrayList<Genres>>


    }
}