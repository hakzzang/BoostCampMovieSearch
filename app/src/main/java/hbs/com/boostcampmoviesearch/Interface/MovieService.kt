package hbs.com.boostcampmoviesearch.Interface

import hbs.com.boostcampmoviesearch.Model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author 문병학
 */
//retrofit에 사용하는 interface 입니다.
interface MovieService {
    //GET TYPE이고 search/{type} 으로 갈 경우
    /**
     * @param X-Naver-Client-Id : naver api의 clientId key
     * @param X-Naver-Client-Secret : naver api의 client Secret key
     * @param type : naver api를 들어가는 구분 값, example: movie.json -> search/movie.json
     * @param query: naver api를 통해서 검색하는 영화 값, example: 스파이더맨 -> 결과값들
     * */
    //retrun으로 Observable을 return해서 rxJava를 사용합니다.
    @GET("search/{type}")
    fun getSearch(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientPw: String,
        @Path("type") type: String,
        @Query("query") query: String
    ): Observable<Movie>
}