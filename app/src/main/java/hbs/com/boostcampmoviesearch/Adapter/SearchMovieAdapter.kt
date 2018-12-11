package hbs.com.boostcampmoviesearch.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.Model.Movie
import hbs.com.boostcampmoviesearch.R
import hbs.com.boostcampmoviesearch.Utils.CONNECT_TYPE
import hbs.com.boostcampmoviesearch.databinding.ItemMovieBinding


class SearchMovieAdapter(mContext: Context, arrayList: ArrayList<*>, requestManager: RequestManager) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var context: Context? = mContext
    private var searchItemList: ArrayList<*> = arrayList
    private var mRequestManager: RequestManager = requestManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            val movieBinding: ItemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)
            return MovieBindingHolder(movieBinding)
        }

        val movieBinding: ItemMovieBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)
        return MovieBindingHolder(movieBinding)

    }

    override fun getItemCount(): Int {
        return searchItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            val movieHolder = holder as MovieBindingHolder
           
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (searchItemList[position] is Movie) {

            return CONNECT_TYPE.MOVIE_SEARCH.status
        }
        return 0
    }

    class MovieBindingHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}