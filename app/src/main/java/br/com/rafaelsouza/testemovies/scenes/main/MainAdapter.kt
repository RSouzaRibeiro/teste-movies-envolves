package br.com.rafaelsouza.testemovies.scenes.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rafaelsouza.testemovies.R
import br.com.rafaelsouza.testemovies.model.Movie
import br.com.rafaelsouza.testemovies.scenes.details.DetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*


class MainAdapter(val context: Context, val listMovies: ArrayList<Movie>):  RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovies[position]

        holder.itemView.titleLabelTXT.text = movie.title
        holder.itemView.mediaTXT.text = movie.media
        holder.itemView.releaseDateTXT.text = movie.dateRelease

        /*Picasso.with(context)
                .load(context.getString(R.string.PATH_GET_IMAGE)+movie.imagePath)
                .into(holder.itemView.movieImageIMG)*/

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.MOVIE_ID, movie.id)
            context.startActivity(intent)


        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)



}