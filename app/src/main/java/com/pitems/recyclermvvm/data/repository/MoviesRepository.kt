package com.pitems.recyclermvvm.data.repository

import com.pitems.recyclermvvm.data.network.MoviesApi

class MoviesRepository ( private val api: MoviesApi):
   SafeApiRequest(){
   suspend fun getMovies()=apiRequest { api.getMovies() }
}