package com.rh.mvp_kotlin_jsonparsing.presenter

import android.util.Log
import com.rh.mvp_kotlin_jsonparsing.contract.MovieListContract
import com.rh.mvp_kotlin_jsonparsing.model.Movie
import com.rh.mvp_kotlin_jsonparsing.service.MovieListModel

class MoviePresenter : MovieListContract.Presenter, MovieListContract.Model.OnfinishListener {

    private var movieListView: MovieListContract.View?
    private lateinit var movieListModel: MovieListContract.Model

    constructor(movieListView: MovieListContract.View) {
        this.movieListView = movieListView
        this.movieListModel = MovieListModel()
    }


    override fun onFinished(movieList: List<Movie>?) {
        movieListView?.setDateRecyclerView(movieList!!)
        movieListView?.hideProgress()
    }

    override fun onFailure(throwable: Throwable) {
        movieListView?.onRespnseFailure(throwable)
        movieListView?.hideProgress()
    }

    override fun onDestroy() {
        movieListView = null
    }

    override fun getMoreData(pageNumber: Int) {
        movieListView?.showProgress()
    }

    override fun requestdataFromServer() {
        movieListView?.showProgress()
        movieListModel.getMovieList(this, 1)
    }


}