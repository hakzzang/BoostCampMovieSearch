package hbs.com.boostcampmoviesearch.LifeCycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.MainVM
import hbs.com.boostcampmoviesearch.Model.Movie
import hbs.com.boostcampmoviesearch.R
import hbs.com.boostcampmoviesearch.databinding.ActivityMainBinding

class MainLifeCycle(var context: Context, private var lifecycle: Lifecycle, var requestManager: RequestManager) :
    LifecycleObserver {
    var searchDatas: ArrayList<Movie.Items> = arrayListOf()

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        var mainActivityBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(context as AppCompatActivity, R.layout.activity_main)
        mainActivityBinding.setVariable(BR.MainVM, MainVM(context, searchDatas, requestManager))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycle.removeObserver(this)
    }


}