package hbs.com.boostcampmoviesearch.Utils

//CONNECT_TYPE은 ViewHolder를 모아놓은 클래스입니다.
enum class CONNECT_TYPE {
    EMPTY_SEARCH(400), MOVIE_SEARCH(1001);


    public var status = 0

    constructor(status: Int) {
        this.status = status
    }
}