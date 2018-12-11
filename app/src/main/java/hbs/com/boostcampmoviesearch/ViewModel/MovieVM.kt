package hbs.com.boostcampmoviesearch.ViewModel

import hbs.com.boostcampmoviesearch.Model.Movie

class MovieVM(private var items: Movie.Items){
    fun getItems(): Movie.Items {
        return items
    }

    fun onCreate(){

    }
}