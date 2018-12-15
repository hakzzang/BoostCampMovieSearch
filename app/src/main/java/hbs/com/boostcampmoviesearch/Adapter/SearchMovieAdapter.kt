package hbs.com.boostcampmoviesearch.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
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

/**
 * @author 문병학
 *
 * 영화 검색시 사용되는 recyclerView의 adapter입니다.
 */
class SearchMovieAdapter(
    private val context: Context,
    private val searchItemList: ArrayList<*>,
    private val requestManager: RequestManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //viewType을 만들어서 viewHodler를 만듭니다.
        //enum class를 통해서 viewHolder를 관리합니다.
        if (viewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            //dataBinding을 사용하기 위해서 view를 DataBindingUtil을 활용해 inflate합니다.
            val movieBinding: ItemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)

            return MovieBindingHolder(movieBinding)
        } else {
            //viewType에 걸리지 않는 것을 통해 viewHolder를 return합니다.
            val emptyViewInflater = LayoutInflater.from(context).inflate(R.layout.item_empty, parent, false)
            return EmptyViewHolder(emptyViewInflater)
        }
    }

    override fun getItemCount(): Int {
        return searchItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //itemViewType이 MOVIE_SEARCH라면
        //databinding 변수들을 셋팅해줍니다.
        if (holder.itemViewType == CONNECT_TYPE.MOVIE_SEARCH.status) {
            val movieHolder = holder as MovieBindingHolder
            val movieItem = searchItemList[position] as Movie.Items
            movieHolder.binding.setVariable(BR.mContext, context)
            movieHolder.binding.setVariable(BR.MovieVM, MovieVM(movieItem))
            movieHolder.binding.setVariable(BR.requestManager, requestManager)
        }
    }

    //data의 자료형을 통해서 viewType을 분리합니다.
    override fun getItemViewType(position: Int): Int {
        if (searchItemList[position] is Movie.Items) {
            return CONNECT_TYPE.MOVIE_SEARCH.status
        }
        return 0
    }

    //영화 목록이 보여지는 Holder
    class MovieBindingHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
    //빈 Holder
    class EmptyViewHolder(emptyView: View) : RecyclerView.ViewHolder(emptyView)
}