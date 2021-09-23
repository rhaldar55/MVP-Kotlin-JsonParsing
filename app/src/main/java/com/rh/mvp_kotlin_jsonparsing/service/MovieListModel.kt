package com.rh.mvp_kotlin_jsonparsing.service

import android.util.Log
import com.rh.mvp_kotlin_jsonparsing.contract.MovieListContract
import com.rh.mvp_kotlin_jsonparsing.model.Movie
import com.rh.mvp_kotlin_jsonparsing.model.MovieListResponse
import com.rh.mvp_kotlin_jsonparsing.network.ApiClient
import com.rh.mvp_kotlin_jsonparsing.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListModel : MovieListContract.Model {

    private val TAG: String = "MovieListModel"
    private var pageNumber = 1

    override fun getMovieList(onfinishListener: MovieListContract.Model.OnfinishListener, pageNumber: Int) {

        val apiservice: ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)

        val call = apiservice.getPopularMovies(ApiClient.API_KEY, pageNumber)
        call.enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                if (response.isSuccessful) {
                    val movies: List<Movie>? = response.body()?.results
                    onfinishListener.onFinished(movies)
                }
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                onfinishListener.onFailure(t)
            }

        })

    }

}