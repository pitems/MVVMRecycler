package com.pitems.recyclermvvm.data.models

data class MoviesResponseItem(
    val id: Int,
    val image: String,
    val is_new: Int,
    val language: String,
    val like_percent: Int,
    val rating: String,
    val title: String,
    val type: String,
    val vote_count: Int
)