package hbs.com.boostcampmoviesearch.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hbs.com.boostcampmoviesearch.LifeCycle.MainLifeCycle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainLifeCycle(this, lifecycle)
    }
}
