package hbs.com.boostcampmoviesearch.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.LifeCycle.MainLifeCycle

class MainActivity : AppCompatActivity() {
    var requestManager: RequestManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestManager = Glide.with(this)
        MainLifeCycle(this, lifecycle, requestManager!!)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this@MainActivity).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this@MainActivity).trimMemory(level)
    }
}
