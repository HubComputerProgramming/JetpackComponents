package com.infoskills.androidpagingapp.network

interface MovieApiService {

    fun getPopularMovies(nextPage:Int)
}