package com.infoskills.androidpagingapp

import android.graphics.Movie
import androidx.paging.PagingSource
import com.infoskills.androidpagingapp.network.MovieApiService

class MoviePagingSource(
    val movieApiService: MovieApiService,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPage = params.key ?: 1
            val response = movieApiService.getPopularMovies(nextPage)

            return LoadResult.Page(
                data = response.movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = response.page + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}