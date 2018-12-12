package hbs.com.boostcampmoviesearch

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.RatingBar
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.Model.Movie
import hbs.com.boostcampmoviesearch.Utils.API_URI

class MovieVM(val movie: Movie.Items) {

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["picture","requestManager"])
        fun setPicture(imageView: ImageView,picture: String, requestManager: RequestManager) {
            if (picture.isEmpty()) {
                return
            }
            requestManager.load(API_URI.MOVIE_SEARCH.uri + picture).into(imageView)
        }

        @JvmStatic
        @BindingAdapter(value = "rating")
        fun doubleToInt(ratingBar: RatingBar,rating: Double) {
            if (rating.isNaN()) {
                return
            }
            ratingBar.numStars = rating.toInt()
        }

    }
}