package br.com.rafaelsouza.testemovies.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun noteService(): Service.NoteService {
        return retrofit.create(Service.NoteService::class.java)
    }
}