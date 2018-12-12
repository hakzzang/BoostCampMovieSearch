package hbs.com.boostcampmoviesearch.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.BR
import hbs.com.boostcampmoviesearch.Model.Movie
import hbs.com.boostcampmoviesearch.MovieVM
import hbs.com.boostcampmoviesearch.R
import hbs.com.boostcampmoviesearch.Utils.CONNECT_TYPE
import hbs.com.boostcampmoviesearch.databinding.ItemMovieBinding


class SearchMovieAdapter(
    private val context: Context, private val searchItemList: ArrayList<*>,
    private val requestManager: RequestManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("movieBinding", "out")
        if (viewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            Log.d("movieBinding", "in")
            val movieBinding: ItemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)

            return MovieBindingHolder(movieBinding)
        } else {
            val emptyViewInflater = LayoutInflater.from(context).inflate(R.layout.item_empty, parent, false)
            return EmptyViewHolder(emptyViewInflater)
        }
    }

    override fun getItemCount(): Int {
        return searchItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            val movieHolder = holder as MovieBindingHolder
            val movieItem = searchItemList[position] as Movie.Items
            movieHolder.binding.setVariable(BR.MovieVM, MovieVM(movieItem))
            movieHolder.binding.setVariable(BR.requestManager, requestManager)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (searchItemList[position] is Movie.Items) {
            return CONNECT_TYPE.MOVIE_SEARCH.status
        }
        return 0
    }

    class MovieBindingHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
    class EmptyViewHolder(emptyView: View) : RecyclerView.ViewHolder(emptyView)
}