package com.pitems.recyclermvvm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pitems.recyclermvvm.data.models.MoviesResponse
import com.pitems.recyclermvvm.data.repository.MoviesRepository
import com.pitems.recyclermvvm.util.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    private lateinit var job:Job
    //Communicate with movies repository
    //Private so it's not exposed outside this class
    private val _movies = MutableLiveData<MoviesResponse>()
    //This one is getting the data from _movies withouth exposing it outside
    val movies: LiveData<MoviesResponse>
    get()=_movies

     fun getMovies(){
         //This will run on the IO Thread or else it would crash
         job= Coroutines.ioThenMain(
             { repository.getMovies()},
             {_movies.value=it}
         )


    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}

//Why use mutablelivedata as private, because view model woon't get any changes done to the mutable live data on runtime so the data on view model
//is immutable so it keeps it data intact until new data is received to the mutable live data