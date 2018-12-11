package hbs.com.boostcampmoviesearch.Utils

enum class CONNECT_TYPE {
    EMPTY_SEARCH(400), MOVIE_SEARCH(1001);


    public var status = 0

    constructor(status: Int) {
        this.status = status
    }
}