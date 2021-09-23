package com.rh.mvp_kotlin_jsonparsing.contract

import com.rh.mvp_kotlin_jsonparsing.model.Movie

interface MovieListContract {
    interface Model{

        interface OnfinishListener{
            fun onFinished(movieList: List<Movie>?)
            fun onFailure(throwable: Throwable)
        }

        fun getMovieList(onfinishListener: OnfinishListener, pageNumber: Int)

    }

    interface View{
        fun showProgress()
        fun hideProgress()
        fun setDateRecyclerView(movieList: List<Movie>)
        fun onRespnseFailure(throwable: Throwable)
    }

    interface Presenter{
        fun onDestroy()
        fun getMoreData(pageNumber: Int)
        fun requestdataFromServer()
    }
}