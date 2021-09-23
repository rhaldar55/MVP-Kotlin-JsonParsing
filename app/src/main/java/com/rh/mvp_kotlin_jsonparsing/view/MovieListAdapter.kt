package com.rh.mvp_kotlin_jsonparsing.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rh.mvp_kotlin_jsonparsing.R
import com.rh.mvp_kotlin_jsonparsing.model.Movie
import com.rh.mvp_kotlin_jsonparsing.network.ApiClient
import com.rh.mvp_kotlin_jsonparsing.view.MovieListAdapter.MyViewHolder

class MovieListAdapter(private val movieList: List<Movie>, private val context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_movie_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMovietitle.text = movieList[position].title
        holder.tvReleaseDate.text = movieList[position].releaseDate
        holder.tvOverview.text = movieList[position].overview
        Glide.with(context).load(ApiClient.IMAGE_BASE_URL + movieList[position].posterPath).into(holder.ivMovie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivMovie: ImageView
        var tvMovietitle: TextView
        var tvReleaseDate: TextView
        var tvOverview: TextView

        init {
            ivMovie = itemView.findViewById(R.id.ivMovie)
            tvMovietitle = itemView.findViewById(R.id.tvTitleMovie)
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseMovie)
            tvOverview = itemView.findViewById(R.id.tvOverviewMovie)
        }
    }
}