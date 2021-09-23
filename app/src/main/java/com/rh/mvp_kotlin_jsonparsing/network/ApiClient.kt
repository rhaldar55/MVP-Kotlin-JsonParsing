package com.rh.mvp_kotlin_jsonparsing.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val BASE_URL = "https://api.themoviedb.org/3/"
    var retrofit: Retrofit? = null
    val API_KEY = "2e901364c3d103dcb00ced520e9bca3c"
    var IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/"


    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}