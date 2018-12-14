package hbs.com.boostcampmoviesearch

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.RatingBar
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.Model.Movie

class MovieVM(val movie: Movie.Items) {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["picture","requestManager"])
        fun ImageView.setPicture(picture: String, requestManager: RequestManager) {

            requestManager.load(picture).into(this)
        }

        @JvmStatic
        @BindingAdapter(value = "rating")
        fun RatingBar.doubleToInt(rating: Double) {
            this.rating = rating.toFloat()
        }

    }
}