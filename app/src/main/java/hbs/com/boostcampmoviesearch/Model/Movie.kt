package hbs.com.boostcampmoviesearch.Model

import java.util.*

class Movie(private var lastBuildDate: Date, private var items:Items){
    data class Items(var title: String, var link: String, var image: String, var subtitle: String, var pubDate: Date, var director: String, var actor: String, var userRating: Int)
}