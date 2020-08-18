package com.pitems.recyclermvvm.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pitems.recyclermvvm.R
import com.pitems.recyclermvvm.databinding.RecyclerviewMovieBinding
import com.pitems.recyclermvvm.data.models.MoviesResponse

class MoviesAdapter (private val movies: MoviesResponse):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){


    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ): RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

    //Get amount of items
    override fun getItemCount(): Int = movies.size
    //Returns a movie view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =MoviesViewHolder(DataBindingUtil.inflate<RecyclerviewMovieBinding>(
        LayoutInflater.from(parent.context),
        R.layout.recyclerview_movie,
        parent,
        false
        )
    )
    //Binds the data to the view holder the last one creates a view holder
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        //Holder is of type MoviesViewHolder
        holder.recyclerviewMovieBinding.movie=movies[position]
    }

}