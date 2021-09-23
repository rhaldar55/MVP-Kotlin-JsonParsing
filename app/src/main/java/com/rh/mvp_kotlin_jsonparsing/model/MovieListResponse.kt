package com.rh.mvp_kotlin_jsonparsing.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieListResponse {
    @SerializedName("page")
    @Expose
    private val page: Int? = null

    @SerializedName("total_results")
    @Expose
    private val totalResults: Int? = null

    @SerializedName("total_pages")
    @Expose
    private val totalPages: Int? = null

    @SerializedName("results")
    @Expose
    val results: List<Movie>? = null
}