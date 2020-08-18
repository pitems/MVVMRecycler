package com.pitems.recyclermvvm.repository

import com.pitems.recyclermvvm.network.MoviesApi
import com.pitems.recyclermvvm.network.SafeApiRequest

class MoviesRepository ( private val api: MoviesApi):
   SafeApiRequest(){
   suspend fun getMovies()=apiRequest { api.getMovies() }
}