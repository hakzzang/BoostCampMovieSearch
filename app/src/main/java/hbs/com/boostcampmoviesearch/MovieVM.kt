package hbs.com.boostcampmoviesearch

import android.content.Context
import android.databinding.BindingAdapter
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.res.ResourcesCompat
import android.text.Html
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.RequestManager
import hbs.com.boostcampmoviesearch.Model.Movie





/**
 * @author
 * MovieViewModel 클래스입니다.
 * */
class MovieVM(val movie: Movie.Items) {
    companion object {
        //picture의 url과 requestManager를 입력해서 imageView에 image를 입히는 dataBinding에 사용하는 adapter입니다.
        @JvmStatic
        @BindingAdapter(value = ["picture", "requestManager"])
        fun ImageView.setPicture(picture: String, requestManager: RequestManager) {
            requestManager.load(picture).into(this)
        }

        //rating의 점수를 입력해서 ratingbar에 rating을 set하는 dataBinding에 사용하는 adapter입니다.
        @JvmStatic
        @BindingAdapter(value = "rating")
        fun RatingBar.doubleToInt(rating: Double) {
            this.rating = rating.toFloat()
        }

        //htmlText를 입력하면 textView에 html을 set하는 dataBinding에 사용하는 adapter입니다.
        @JvmStatic
        @BindingAdapter(value = ["htmlText"])
        fun TextView.setHTmlText(htmlText: String) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                this.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
            } else {
                this.text = Html.fromHtml(htmlText)
            }
        }

        //item을 click할 시에, context와 이동할 url을 받아 startActivity를 실행하는 adapter입니다.
        @JvmStatic
        @BindingAdapter(value = ["startActivity", "linkUrl"])
        fun LinearLayout.startActivity(context: Context, linkUrl: String) {
            this.setOnClickListener {
                val builder = CustomTabsIntent.Builder().setShowTitle(true)

                // Change the background color of the Toolbar.
                builder.setToolbarColor(ResourcesCompat.getColor(resources, R.color.colorPrimary, null))
                builder.setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_left);
                builder.setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right);
                builder.setCloseButtonIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_arrow_back_black_24dp));
                builder.enableUrlBarHiding();
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(context, Uri.parse(linkUrl))
            }
        }
    }


}