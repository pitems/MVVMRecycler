package com.pitems.recyclermvvm.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pitems.recyclermvvm.data.repository.MoviesRepository

class MoviesViewModelFactory (private val repository: MoviesRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //Returns the View Model with the repository as parameter
        return MoviesViewModel(repository) as T
    }
}