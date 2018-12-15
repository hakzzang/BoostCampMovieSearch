package hbs.com.boostcampmoviesearch

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.Adapter.SearchMovieAdapter
import hbs.com.boostcampmoviesearch.Model.Movie
import hbs.com.boostcampmoviesearch.Utils.SearchService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * @author 문병학
 * MainViewModel 클래스입니다
 * */
class MainVM(val context: Context, var searchDatas: ArrayList<Movie.Items>, var requestManager: RequestManager) {
    var searchWord: MutableLiveData<String>? = MutableLiveData() //검색할 영화 제목
    var searchMovieAdapter = SearchMovieAdapter(context, searchDatas, requestManager) //어댑터 생성


    @SuppressLint("CheckResult")
    fun findMovie(searchWord: MutableLiveData<String>) {
        clearDatas() //찾기 전에 recyclerView와 data 초기화
        val movieRetrofit = SearchService().movieRetrofit//retrofit을 가져옴
        if (searchWord.value.isNullOrEmpty()) {//searchWord의 값이 비었다면 return
            return
        }
        movieRetrofit.getSearch(
            clientId = getResourceString(R.string.naver_client_id),
            clientPw = getResourceString(R.string.naver_client_secret),
            type = "movie.json",
            query = searchWord.value!!
        ).subscribeOn(Schedulers.io())//subscribeOn, subscribe시에 사용할 스레드 :  Schedulers.io를 통해 비동기화 시킵니다.
            .observeOn(AndroidSchedulers.mainThread())//observer시에 사용할 스레드 : Android ui thread에서 동작
            .subscribe({ movie ->
                movie!!.items.iterator().forEach {
                    searchDatas.add(it)
                    searchMovieAdapter.notifyItemInserted(searchDatas.size - 1)
                }
            }, { error -> Log.d("error", error.toString()) }
                , {  Log.d("onComplete", "onComplete") }
            )
    }

    private fun clearDatas() {
        searchMovieAdapter.notifyItemRangeRemoved(0, searchDatas.size)//recyclerView ui 초기화
        searchDatas.clear() //이전 데이터를 클리어
    }

    private fun getResourceString(resourceId: Int): String {
        return context.resources.getString(resourceId)
    }
}