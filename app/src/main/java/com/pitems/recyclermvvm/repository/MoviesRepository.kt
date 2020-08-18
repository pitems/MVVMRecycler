package com.pitems.recyclermvvm.repository

import com.pitems.recyclermvvm.MoviesApi
import com.pitems.recyclermvvm.SafeApiRequest

class MoviesRepository ( private val api:MoviesApi):SafeApiRequest(){
   suspend fun getMovies()=apiRequest { api.getMovies() }
}