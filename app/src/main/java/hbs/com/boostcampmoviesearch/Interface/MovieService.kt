package hbs.com.boostcampmoviesearch.Interface

import hbs.com.boostcampmoviesearch.Model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("search/{type}")
    fun getSearch(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientPw: String,
        @Path("type") type: String,
        @Query("query") query: String
    ): Observable<Movie>
}