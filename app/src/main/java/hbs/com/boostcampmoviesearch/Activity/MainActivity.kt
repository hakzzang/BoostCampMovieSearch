package hbs.com.boostcampmoviesearch.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.LifeCycle.MainLifeCycle


/**
 * @author 문병학
 *
 * MainActivity 클래스로, 어플리케이션의 진입점입니다.
 * */
class MainActivity : AppCompatActivity() {
    //Glide 객체를 하나로 유지하는 변수입니다.
    var requestManager: RequestManager? = null

    //onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestManager = Glide.with(this)
        //LifeCycle 라이브러리를 활용해 클래스로 관리합니다.
        MainLifeCycle(this, lifecycle, requestManager!!)
    }

    //Glide 객체의 효율성을 증가시키기 위해서 lowMemory시에 메모리를 clear합니다.
    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this@MainActivity).clearMemory()
    }

    //Glide 객체의 효율성을 증가시키기 위해서 memory의 level을 넘겨줍니다.
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this@MainActivity).trimMemory(level)
    }
}