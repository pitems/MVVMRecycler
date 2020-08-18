package com.pitems.recyclermvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pitems.recyclermvvm.network.response.MoviesResponse
import com.pitems.recyclermvvm.repository.MoviesRepository

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    //Communicate with movies repository
    //Private so it's not exposed outside this class
    private val _movies = MutableLiveData<MoviesResponse>()
    //This one is getting the data from _movies withouth exposing it outside
    val movies: LiveData<MoviesResponse>
    get()=_movies

    suspend fun getMovies(){
        val movies=repository.getMovies()
        _movies.value=movies
    }

}

//Why use mutablelivedata as private, because view model woon't get any changes done to the mutable live data on runtime so the data on view model
//is immutable so it keeps it data intact until new data is received to the mutable live data