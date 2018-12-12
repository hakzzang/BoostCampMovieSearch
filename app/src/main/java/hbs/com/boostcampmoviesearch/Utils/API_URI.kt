package hbs.com.boostcampmoviesearch.Utils

enum class API_URI {
    MOVIE_SEARCH("https://openapi.naver.com/v1/");

    var uri = ""

    constructor(uri: String) {
        this.uri = uri
    }
}