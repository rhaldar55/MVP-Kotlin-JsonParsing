package com.rh.mvp_kotlin_jsonparsing

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rh.mvp_kotlin_jsonparsing.contract.MovieListContract
import com.rh.mvp_kotlin_jsonparsing.model.Movie
import com.rh.mvp_kotlin_jsonparsing.presenter.MoviePresenter
import com.rh.mvp_kotlin_jsonparsing.view.MovieListAdapter
import java.util.*

class MainActivity : AppCompatActivity(), MovieListContract.View {

    private lateinit var moviePresenter: MoviePresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: List<Movie>
    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var progressBar: ProgressBar
    private  var pageNumber = 1
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView  =  findViewById(R.id.rvMovieList)
        progressBar = findViewById(R.id.pbLoading)
        movieList = ArrayList<Movie>()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)

        moviePresenter = MoviePresenter(this)
        moviePresenter.requestdataFromServer()

    }

    override fun showProgress() {
        progressBar.visibility=View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility=View.GONE
    }

    override fun setDateRecyclerView(movieList: List<Movie>) {
        this.movieList = movieList
        movieListAdapter = MovieListAdapter(this.movieList, this)
        recyclerView.adapter= movieListAdapter
    }

    override fun onRespnseFailure(throwable: Throwable) {
       Toast.makeText(this, "Error in getting data", Toast.LENGTH_SHORT).show()
    }
}