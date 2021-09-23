package com.rh.mvp_kotlin_jsonparsing.network

import com.rh.mvp_kotlin_jsonparsing.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") pageNo: Int
    ): Call<MovieListResponse>
}