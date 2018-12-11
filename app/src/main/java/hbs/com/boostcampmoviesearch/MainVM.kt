package hbs.com.boostcampmoviesearch

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.util.Log
import hbs.com.boostcampmoviesearch.Adapter.SearchMovieAdapter

class MainVM {
    var searchWord: MutableLiveData<String>? = null

    init {
        searchWord = MutableLiveData()
    }

    fun findMovie(searchWord:MutableLiveData<String>) {
        Log.d("searchWord", searchWord.value)
    }

    @BindingAdapter("adapter")
    fun setAdapter(){
        var searchMovieAdapter = SearchMovieAdapter()
    }
}