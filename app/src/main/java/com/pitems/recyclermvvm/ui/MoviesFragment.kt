package com.pitems.recyclermvvm.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.pitems.recyclermvvm.R
import com.pitems.recyclermvvm.network.MoviesApi
import com.pitems.recyclermvvm.repository.MoviesRepository

class MoviesFragment : Fragment() {
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository= MoviesRepository(api)
        factory = MoviesViewModelFactory(repository = repository)
        viewModel = ViewModelProvider(this,factory).get(MoviesViewModel::class.java) //This get us our view model

    }

}